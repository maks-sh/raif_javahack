/**
 * Составные идентификаторы доменных сущностей.
 * Партиционные и кластерные ключи сущности выбирались в основном из подходов:
 * 1) table per query
 * 2) (not more than) partition per request
 *
 * P.S. PK в Java-doc`ах классов данного пакета означает "Partition key"
 */
package javahack.raif.borsch.domain.ids;