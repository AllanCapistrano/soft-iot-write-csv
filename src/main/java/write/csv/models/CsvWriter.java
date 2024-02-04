package write.csv.models;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
import write.csv.services.CsvWriterService;

/**
 * Responsável por criar e escrever em um arquivo .csv.
 *
 * @author Allan Capistrano
 * @version 1.0.0
 */
public class CsvWriter implements CsvWriterService {

  private String fileName;
  private String filePath;
  private String header;
  private CSVWriter writer;
  private static final Logger logger = Logger.getLogger(
    CsvWriter.class.getName()
  );

  /**
   * Executa o que foi definido na função quando o bundle for inicializado.
   */
  public void start() {
    File file = new File(this.filePath + this.fileName);

    try {
      FileWriter outputFile = new FileWriter(file);
      this.writer = new CSVWriter(outputFile);
      writer.writeNext(this.header.split(","));
    } catch (IOException ioe) {
      logger.severe(ioe.getMessage());
    }
  }

  /**
   * Executa o que foi definido na função quando o bundle for finalizado.
   */
  public void stop() {
    this.closeFile();
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

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
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
