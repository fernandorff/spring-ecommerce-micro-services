package com.ff.productservice.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

  private final String region = "us-east-2";

  private final String accessKey = "AKIATGG5RTUXIMB6R7VE";

  private final String secretKey = "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";

  @Bean
  public AmazonS3 amazonS3() {
    BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);

    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
        .withRegion(region)
        .build();

    return s3Client;
  }
}
