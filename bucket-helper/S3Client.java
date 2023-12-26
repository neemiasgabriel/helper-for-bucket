@Component
public class S3Client {
  private final MiniIoProperties ioProperties;

  @Bean("ioClient")  
  public AmazonS3 ioClient() {  
    final var ioProvider = new BasicAWSCredentials(ioProperties.getAccessKey(), ioProperties.getSecretKey());  
    
    return AmazonS3Client.builder()  
        .withCredentials(new AWSStaticCredentialsProvider(ioProvider))  
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ioProperties.getHost(), ioProperties.getRegion()))  
        .withPathStyleAccessEnabled(true)  
        .build();  
  }
}