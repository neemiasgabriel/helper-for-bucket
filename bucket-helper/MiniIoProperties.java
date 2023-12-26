@Getter
@Component
public class MiniIoProperties {
  private final String host;
  private final String accessKey;
  private final String secretKey;
  private final String region;
  private final String bucket;

  public MiniIoProperties(
      @Value("${miniio.bucket.host}") final String host,
      @Value("${miniio.bucket.accessKey}") final String accessKey,
      @Value("${miniio.bucket.secretKey}") final String secretKey,
      @Value("${miniio.bucket.region}") final String region,
      @Value("${miniio.bucket.bucketName}") final String bucket) {
    this.host = host;
    this.accessKey = accessKey;
    this.secretKey = secretKey;
    this.region = region;
    this.bucket = bucket;
  }
}