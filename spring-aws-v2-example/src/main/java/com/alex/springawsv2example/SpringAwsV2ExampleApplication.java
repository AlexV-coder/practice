package com.alex.springawsv2example;

import com.alex.springawsv2example.configuration.DynamoProperties;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.awscore.client.builder.AwsClientBuilder;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3ClientBuilder;

import java.net.URI;

@SpringBootApplication
@EnableConfigurationProperties(DynamoProperties.class)
public class SpringAwsV2ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAwsV2ExampleApplication.class, args);
	}

	@Bean
	AwsCredentials awsCredentials() {
		return new AwsCredentials() {
			@Override
			public String accessKeyId() {
				return "access_key";
			}

			@Override
			public String secretAccessKey() {
				return "secret_key";
			}
		};
	}
	@Bean
	DynamoDbClient dynamoDbClient(DynamoProperties dynamoProperties) {
		return apply(dynamoProperties, DynamoDbClient.builder()).build();
	}

	@Bean
	S3Client s3Client(DynamoProperties dynamoProperties) {
		return apply(dynamoProperties, S3Client.builder()).build();
	}

	public <BuilderT extends AwsClientBuilder<BuilderT, ClientT>, ClientT> AwsClientBuilder<BuilderT, ClientT> apply(DynamoProperties dynamoProperties, AwsClientBuilder<BuilderT, ClientT> builder) {
		if(dynamoProperties.getEndpointURI() != null) {
			builder
					.endpointOverride(dynamoProperties.getEndpointURI())
					.region(Region.EU_WEST_1)
					.credentialsProvider(() -> awsCredentials());
		}
		return builder;
	}

	@Bean
	ApplicationRunner applicationRunner(DynamoDbClient dynamoDbClient) {
		return args -> {
			dynamoDbClient.listTables().tableNames().forEach(s -> System.out.println("Before Table: " + s));

			CreateTableRequest createTableRequest = CreateTableRequest
					.builder()
					.tableName("book")
					.keySchema(KeySchemaElement
							.builder()
							.keyType(KeyType.HASH)
							.attributeName("id")
							.build())
					.attributeDefinitions(AttributeDefinition
							.builder()
							.attributeName("id")
							.attributeType(ScalarAttributeType.S)
							.build())
					.provisionedThroughput(ProvisionedThroughput
							.builder()
							.writeCapacityUnits(5L)
							.readCapacityUnits(5L)
							.build())
					.build();

			dynamoDbClient.createTable(createTableRequest);

			dynamoDbClient.listTables().tableNames().forEach(s -> System.out.println("After Table: " + s));
		};
	}

}
