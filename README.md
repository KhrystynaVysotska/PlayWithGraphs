# Державна установа

Для закордонної поїздки вам потрiбно отримати кiлька довiдок вiд держустанови.
Проте, виявилося, що для отримання цих довiдок потрiбнi iншi довiдки, а тi, в свою
чергу, потребують ще iнших довiдок.

На отримання кожної довiдки потрiбно вистояти чергу, тому ви хочете зекономити
час, не стоячи в черзi дарма (якщо ви не будете мати потрiбних довiдок, стоячи в
черзi, вам вiдмовлять у видачi цiєї).

Маючи iнформацiю про те, якi довiдки потрiбнi для яких, визначте оптимальний
порядок отримання усiх довiдок, при якому вам жодного разу не вiдмовлять у
видачi. Якщо таких оптимальних варiантiв кiлька — виведiть будь-який iз них.
### *Вхiднi данi*

Кожен iз N рядкiв вхiдного файлу govern .in мiстить два слова, роздiленi пробiлом
— назва довiдки та довiдка, яку потрiбно отримати перед нею.

- Рядкiв може бути вiд 1 до 100000.
- Слова мають довжину вiд 1 до 50 лiтер i складаються з цифр 0-9 i малих лiтер
латинського алфавiту вiд a до z.
- Якщо для однiєї довiдки потрiбно отримати N iнших, файл мiститиме N рядкiв,
що починатимуться на одне й те саме слово.
- Гарантовано iснує хоча б один порядок отримання довiдок, при якому можна
отримати усi довiдки.

### *Вихiднi данi*

Вихiдний файл govern .out повинен мiстити M рядкiв — назви довiдок в порядку їх
рекомендованого отримання.

*Примiтка*: Пiсля останнього слова також повинен бути символ переносу рядка (new-
line).

>### Приклад 1
>
>#### govern .in
>
>visa foreignpassport \
>visa hotel \
>visa bankstatement \
>bankstatement nationalpassport \
>hotel creditcard \
>creditcard nationalpassport \
>nationalpassport birthcertificate \
>foreignpassport nationalpassport \
>foreignpassport militarycertificate \
>militarycertificate nationalpassport 
>
>#### govern .out
>birthcertificate \
>nationalpassport \
>militarycertificate \
>foreignpassport \
>creditcard \
>hotel \
>bankstatement \
>visa

>### Приклад 2
>
>#### govern .in
>
>visa foreignpassport
>
>#### govern .out
>foreignpassport \
>visa

## Algorithm
In my solution I used an oriented unweighted graph represented as an adjacency list.
To find optimal sequence of certificates I implemented DFS.
It takes graph object as a parameter and returns a list of certificates in optimal order.

## Installation
 - Make sure you have [Maven](https://maven.apache.org/) installed

 - Use [git](https://git-scm.com/downloads/) to clone this project

```bash
 git clone https://github.com/KhrystynaVysotska/PlayWithGraphs.git
```
## Usage
- from root project folder run *mvn package* or *mvn install*
- then from root folder run 

```bash
java -cp PATH_TO_JAR_FILE ua.lviv.iot.launcher.Launcher PATH_TO_INPUT_FILE PATH_TO_OUTPUT_FILE
```
