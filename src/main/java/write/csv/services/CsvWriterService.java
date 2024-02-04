package write.csv.services;

/**
 *
 * @author Allan Capistrano
 * @version 1.0.0
 */
public interface CsvWriterService {
  /**
   * Escreve e salva os dados no arquivo .csv.
   *
   * @param data String[] - Dados que serão gravados no arquivo.
   */
  public void writeData(String[] data);

  /**
   * Fecha o arquivo .csv.
   */
  public void closeFile();
}
