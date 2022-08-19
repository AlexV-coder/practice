package com.alex.springawsv2example.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties("dynamo")
@Data
public class DynamoProperties {
    private URI endpointURI;
}
