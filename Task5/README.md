### Regular expression

Написать регулярное выражение, определяющее является ли данная строчка 
валидным URL адресом. В данной задаче правильным URL считаются адреса 
http и https, явное указание протокола также может отсутствовать. 
Учитываются только адреса, состоящие из символов, т.е. IP адреса в 
качестве URL не присутствуют при проверке. Допускаются поддомены, 
указание порта доступа через двоеточие, GET запросы с передачей 
параметров, доступ к подпапкам на домене, допускается наличие якоря 
через решетку. Однобуквенные домены считаются запрещенными. Запрещены 
спецсимволы, например «–» в начале и конце имени домена. Запрещен символ 
«_» и пробел в имени домена. При составлении регулярного выражения 
ориентируйтесь на список правильных и неправильных выражений заданных 
ниже. Пример правильных выражений: http://www.zcontest.ru, 
http://zcontest.ru. Пример неправильных выражений: Just TextElement, 
http://a.com. 

Написать поисковый сервис: по произвольному URL перейти и спомощью 
регулярного выражения найти 20 URL каждому указываете ключевые слова 
с частотами по указаному слову; найти все URL упорядоченые по 
возрастанию частоты слова.