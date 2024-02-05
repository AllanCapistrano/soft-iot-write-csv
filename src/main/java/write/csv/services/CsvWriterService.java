package write.csv.services;

/**
 *
 * @author Allan Capistrano
 * @version 1.0.1
 */
public interface CsvWriterService {
  /**
   * Cria o arquivo .csv.
   *
   * @param fileName String - Nome do arquivo. Obs: Não é necessário passar o
   * .csv
   */
  public void createFile(String fileName);

  /**
   * Escreve e salva os dados no arquivo .csv.
   *
   * @param data String[] - Dados que serão gravados no arquivo.
   */
  public void writeData(String[] data);
}
