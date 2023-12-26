public interface BucketClient {
  /**
   * Lê um arquivo dentro do bucket
   *
   * @param filePath  caminho para acessar o arquivo, no bucket
   * @param objectKey nome do arquivo
   * @return Os bytes do arquivo pedido
   * @throws FileReadingException    Não foi possível ler o arquivo
   * @throws InternalServerException Falha interna do sistema
   */
  InputStream readFile(final String filePath, final String objectKey)
      throws FileReadingException, InternalServerException;

  /**
   * Deleta o arquivo especificado na pasta, dentro do bucket
   *
   * @param srcFolder Pasta raiz
   * @param fileName  Nome do arquivo
   */
  void deleteFileFrom(final String srcFolder, final String fileName);

  /**
   * Copia um arquivo de uma pasta, para outra, dentro do bucket especificado
   *
   * @param srcFolder    Pasta raiz
   * @param fileName     Nome do arquivo
   * @param targetFolder Pasta destino
   */
  void copyFileTo(final String srcFolder, final String fileName, final String targetFolder);

  /**
   * Move um arquivo de uma pasta para outra. Uma vez que não existe a operação de recortar, é preciso fazer uma cópia, <br>
   * seguida por uma deleção.
   *
   * @param srcFolder    Pasta raiz
   * @param targetFolder Pasta destino
   * @param fileName     Nome do Arquivo
   */
  void moveFile(final String srcFolder, final String fileName, final String targetFolder);

  /**
   * Move os arquivos que estão na pasta IN, para a pasta OUT
   */
  void moveFilesToOut();

  /**
   * Lê todos os arquivos dentro do path especificado
   *
   * @param filePath Caminho para o arquivo
   * @return Lista com os metadados dos arquivos lidos
   * @throws FileReadingException    Não foi possível ler o arquivo
   * @throws InternalServerException Falha interna do sistema
   */
  List<FileInfo> readAllFiles(final String filePath) throws FileReadingException, InternalServerException;

  /**
   * Copia arquivo de uma pasta para outra.
   *
   * @param srcFolder    Pasta raiz
   * @param objectKey    Nome do arquivo
   * @param targetFolder Pasta destino
   * @throws FileReadingException    Não foi possível ler o arquivo
   * @throws InternalServerException Falha interna do sistema
   */
  void copyFile(final String srcFolder, final String objectKey, final String targetFolder)
      throws FileReadingException, InternalServerException;

  /**
   * Sobe um arquivo para o bucket.
   *
   * @param fileName Nome do arquivo, dentro da aplicação, que irá para o bucket
   * @param filePath Caminho onde o arquivo será adicionado no bucket
   * @return boolean. True, se o arquivo foi enviado. False, caso contrário
   * @throws FileReadingException    Não foi possível ler o arquivo
   * @throws InternalServerException Falha interna do sistema
   */
  boolean uploadFile(final String fileName, final String filePath) throws FileReadingException, InternalServerException;

  /**
   * Recebe o arquivo que deve subir para o Bucket. Antes do arquivo ser enviado, a validação do nome do arquivo é realizada.
   * Se o nome não for validado pela regra, uma FileReadingException deve ser lançada.
   *
   * @param multipartFile Arquivo recebido pela requisição
   */
  void uploadFileFromRequest(final MultipartFile multipartFile);
}
