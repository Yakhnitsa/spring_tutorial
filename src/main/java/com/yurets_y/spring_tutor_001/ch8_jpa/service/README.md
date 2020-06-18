Для работы с criteriaQuery необходимо произвести некоторые настройки.
Работа происходит через StaticMetamodel, для ее генерации можно воспользоваться ручными инструментами:
в тупую переписать код для класса выборки со всеми полями, и указать его метамодель.
Либо воспользоваться библиотекой hibernate-jpamodelgen для maven.
Для этого добавляем зависимость в maven: 

        <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-jpamodelgen -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-jpamodelgen</artifactId>
            <version>${hibernate.version}</version>
            <scope>provided</scope>
        </dependency>
В секции плагинов сборки добавляем плагин

    <plugin>
                <groupId>org.bsc.maven</groupId>
                <artifactId>maven-processor-plugin</artifactId>
                <version>2.0.5</version>
                <executions>
                    <execution>
                        <id>process</id>
                        <goals>
                            <goal>process</goal>
                        </goals>
                        <phase>generate-sources</phase>
                        <configuration>
                            <processors>
                                <processor>org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor</processor>
                            </processors>
                        </configuration>
                    </execution>
                </executions>
                <dependencies>
                    <dependency>
                        <groupId>org.hibernate</groupId>
                        <artifactId>hibernate-jpamodelgen</artifactId>
                        <version>5.3.17.Final</version>
                    </dependency>
                </dependencies>
            </plugin>        
            
            
Для запуска в IDE настраиваем AnnotationProcessor
- Enable annotation processor
- добавляем процессор к проекту org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor
Подробнее об [использовании](https://docs.jboss.org/hibernate/stable/jpamodelgen/reference/en-US/html_single/#d0e233 )              