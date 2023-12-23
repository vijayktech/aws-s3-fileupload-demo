package org.example;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        AWSCredentials awsCredentials = getAwsCred();

        AmazonS3 s3Client= AmazonS3ClientBuilder
                .standard()
                .withRegion("ap-south-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        // bucket name - mybktlambda
          List<Bucket> s3List  = s3Client.listBuckets();
          for( Bucket bucket : s3List ){
              System.out.println("Bucket Name: "+bucket);
          }
    }

    private static AWSCredentials getAwsCred(){
        return new BasicAWSCredentials("",
                "");
    }

}
