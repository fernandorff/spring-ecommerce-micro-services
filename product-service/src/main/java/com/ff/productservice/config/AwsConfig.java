package com.ff.productservice.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

  private static final String REGION = "us-east-2";

  private static final String ACCESS_KEY = "AKIATGG5RTUXIMB6R7VE";

  private static final String SECRET_KEY = "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";

  @Bean
  public AmazonS3 amazonS3() {
    BasicAWSCredentials awsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);

    return AmazonS3ClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
        .withRegion(REGION)
        .build();
  }
}
