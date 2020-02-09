Использовал: Spring(5.2.3), Hibernate(5.4.3), PostgreSQL 11
Развертывание на базе Tomcat(9.0.27)
Реализовано все по заданию, а также web user interface и unit tests.

Ссылка на полную верисю:
https://github.com/EugeneBlizniuk/GT_Assignment

Чтобы запустить приложение:
1) Скачать приложение: git clone https://github.com/EugeneBlizniuk/GT_Assignment
2) Создать БД, таблицы и добавить данные можно по скриптам ниже(пункт 1).
3) Опциональные пункты:
  a) Add Framework support... -> Hibernate -> ok
  b) View -> Tool Windows -> Persistence(откроется вкладка) -> 
  правая кнопка мыши выбираем Assign Data Sources -> в Data Source указываем соединение с БД и жмем ОК.
  c) В файле db.properties установить свои user и password.
4) После настроить конфигурации для Tomcat и можно запускать.
