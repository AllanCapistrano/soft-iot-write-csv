package write.csv.models;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
import write.csv.services.CsvWriterService;

/**
 * Responsável por criar e escrever em um arquivo .csv.
 *
 * @author Allan Capistrano
 * @version 1.0.1
 */
public class CsvWriter implements CsvWriterService {

  private String filePath;
  private String header;
  private CSVWriter writer;
  private static final Logger logger = Logger.getLogger(
    CsvWriter.class.getName()
  );

  /**
   * Cria o arquivo .csv.
   *
   * @param fileName String - Nome do arquivo. Obs: Não é necessário passar o
   * .csv
   */
  public void createFile(String fileName) {
    try {
      String fileCompletePath = this.filePath + fileName + ".csv";
      FileWriter fileWriter = new FileWriter(fileCompletePath, true);

      this.writer = new CSVWriter(fileWriter);
      this.writer.writeNext(this.header.split(","));
      this.writer.flush();
    } catch (IOException ioe) {
      logger.severe(ioe.getMessage());
    }
  }

  /**
   * Escreve e salva os dados no arquivo .csv.
   *
   * @param data String[] - Dados que serão gravados no arquivo.
   */
  public void writeData(String[] data) {
    try {
      this.writer.writeNext(data);
      this.writer.flush();
    } catch (IOException ioe) {
      logger.severe(ioe.getMessage());
    }
  }

  /**
   * Fecha o arquivo .csv.
   */
  public void closeFile() {
    try {
      this.writer.close();
    } catch (IOException ioe) {
      logger.severe(ioe.getMessage());
    }
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }
}
