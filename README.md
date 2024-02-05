# SOFT-IoT-Write-CSV

O `SOFT-IoT-Write-CSV` é um *bundle* OSGI responsável por criar e escrever arquivos [CSV](https://en.wikipedia.org/wiki/Comma-separated_values).

## Configurações
| Propriedade | Descrição | Valor Padrão |
| ----------- | --------- | ------------ |
| filePath | Caminho onde o arquivo será armazenado | `/opt/karaf/etc/csv/` |
| header<sup>1</sup> | Cabeçalho do arquivo .csv | `Node_ID,C(n),R,Tr(n),Cr_old(n),Cr_new(n)` |

###### Obs<sup>1</sup>: O cabeçalho deve ser separado por vírgulas e sem espaço. ######

## Licença
[GPL-3.0 License](./LICENSE)
