# API

API służące do wyświetlania informacji o podanym ciągu znaków takich jak liczba cyfr, liczba znaków specjalnych itp. w
trzech formatach: TXT, JSON, XML oraz CSV.

## Użycie

Aby skorzystać z API, należy wysłać żądanie GET pod wybrany endpoint (w zależności od formatu, w jakim chcemy otrzymać
dane o naszym ciągu znaków):

```
ścieżka_do_api/txt/{tekst}
ścieżka_do_api/json/{tekst}
ścieżka_do_api/xml/{tekst}
ścieżka_do_api/csv/{tekst}
```

## Przykłady

```
1. http://localhost:8081/api/txt/Happy%20New%202022%20Year!
2. http://localhost:8081/api/json/Happy%20New%202022%20Year!
3. http://localhost:8081/api/xml/Happy%20New%202022%20Year!
4. http://localhost:8081/api/csv/Happy%20New%202022%20Year!
```

## Wyniki dla poszczególnych wywołań

### 1. Format tekstowy

#### Wywołanie API:

```
http://localhost:8081/api/txt/Happy%20New%202022%20Year!
```

#### Wynik:

```
Text: Happy New 2022 Year!
Digits: 4
Upper case: 3
Lower case: 9
Whitespace: 3
Special characters: 1
```

### 2. Format JSON

#### Wywołanie API:

```
http://localhost:8081/api/json/Happy%20New%202022%20Year!
```

#### Wynik:

```json
{
  "text": "Happy New 2022 Year!",
  "digits": 4,
  "upperCase": 3,
  "lowerCase": 9,
  "whitespace": 3,
  "specialCharacters": 1
}
```

### 3. Format XML

#### Wywołanie API:

```
http://localhost:8081/api/xml/Happy%20New%202022%20Year!
```

#### Wynik:

```xml
<stringData>
    <upperCase>3</upperCase>
    <lowerCase>9</lowerCase>
    <specialCharacters>1</specialCharacters>
    <digits>4</digits>
    <text>Happy New 2022 Year!</text>
    <whitespace>3</whitespace>
</stringData>
```

### 4. Format CSV

#### Wywołanie API:

```
http://localhost:8081/api/csv/Happy%20New%202022%20Year!
```

#### Wynik:

```
upperCase,lowerCase,specialCharacters,digits,text,whitespace
3,9,1,4,Happy New 2022 Year!,3
```

#### Wynik dla formatu CSV przedstawiony w postaci tabeli (dla lepszej czytelności):

| upperCase | lowerCase | specialCharacters | digits |         text         | whitespace |
| --------- | --------- | ----------------- | ------ | -------------------- | ---------- |
|     3     |     9     |         1         |    4   | Happy New 2022 Year! |     3     |