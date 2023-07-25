
fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}
import 'package:flutter/material.dart';
import 'dart:math';

void main() => runApp(MagicBallApp());

class MagicBallApp extends StatelessWidget {
    @override
    Widget build(BuildContext context) {
        return MaterialApp(
            title: 'Magic Ball',
        theme: ThemeData(
        primarySwatch: Colors.blue,
        ),
        home: MagicBallPage(),
        );
    }
}

class MagicBallPage extends StatefulWidget {
    @override
    _MagicBallPageState createState() => _MagicBallPageState();
}

class _MagicBallPageState extends State<MagicBallPage> {
    String _answer = '';

    void _getAnswer() {
        setState(() {
            // Генерируем случайный ответ
            List<String> answers = [
                    'Определенно да',
                    'Да',
                    'Весьма вероятно',
                    'Сомнительно',
                    'Весьма сомнительно',
            ];
            _answer = answers[Random().nextInt(answers.length)];
        });
    }

    @override
    Widget build(BuildContext context) {
        return Scaffold(
            appBar: AppBar(
                    title: Text('Magic Ball'),
        ),
        body: Center(
        child: GestureDetector(
        onTap: _getAnswer,
        onLongPress: _getAnswer,
        child: Container(
        decoration: BoxDecoration(
        shape: BoxShape.circle,
        color: Colors.blue,
        ),
        width: 200,
        height: 200,
        child: Center(
        child: Text(
        _answer,
        style: TextStyle(fontSize: 24, color: Colors.white),
        ),
        ),
        ),
        ),
        ),
        );
    }
}
import 'package:flutter/material.dart';

void main() {
    runApp(MyApp());
}

class MyApp extends StatelessWidget {
    @override
    Widget build(BuildContext context) {
        return MaterialApp(
            title: 'Приветственное приложение',
        theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
        ),
        home: MyHomePage(title: 'Добро пожаловать!'),
        );
    }
}

class MyHomePage extends StatelessWidget {
    final String title;

    MyHomePage({Key key, this.title}) : super(key: key);

    @override
    Widget build(BuildContext context) {
        return Scaffold(
            appBar: AppBar(
                    title: Text(title),
        ),
        body: Center(
        child: Text(
        'Привет, добро пожаловать в мое приложение!',
        style: TextStyle(fontSize: 24),
        ),
        ),
        );
    }
}
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Параллакс-эффект</title>
<style>
body {
    margin: 0;
    overflow: hidden;
    perspective: 1000px;
}

.container {
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.sphere {
    width: 300px;
    height: 300px;
    position: relative;
    transform-style: preserve-3d;
    animation: rotate 10s infinite linear;
}

.star {
    position: absolute;
    width: 10px;
    height: 10px;
    background-color: gold;
    border-radius: 50%;
    transform: translateZ(500px) rotateX(0deg) rotateY(0deg);
    animation: float 6s infinite ease-in-out alternate;
}

@keyframes rotate {
    0% {
        transform: rotateY(0deg);
    }
    100% {
        transform: rotateY(360deg);
    }
}

@keyframes float {
    0% {
        transform: translateZ(500px) rotateX(0deg) rotateY(0deg);
    }
    50% {
        transform: translateZ(250px) rotateX(180deg) rotateY(-180deg);
    }
    100% {
        transform: translateZ(500px) rotateX(360deg) rotateY(-360deg);
    }
}
</style>
</head>
<body>
<div class="container">
<div class="sphere">
<!-- Здесь будут добавлены звезды динамически через JavaScript -->
</div>
</div>

<script>
function createStars() {
    const sphere = document.querySelector('.sphere');
    const numberOfStars = 200;

    for (let i = 0; i < numberOfStars; i++) {
        const star = document.createElement('div');
        star.className = 'star';
        star.style.transform = `rotateY(${Math.random() * 360}deg) rotateX(${Math.random() * 360}deg) translateZ(${Math.random() * 500}px)`;

        sphere.appendChild(star);
    }
}

createStars();
</script>
</body>
</html>

import 'package:flutter_tts/flutter_tts.dart';

class YourPage extends StatefulWidget {
    @override
    _YourPageState createState() => _YourPageState();
}

class _YourPageState extends State<YourPage> {
    FlutterTts flutterTts = FlutterTts();

    void speakResponse(String response) async {
        await flutterTts.setLanguage("en-US"); // Установка языка (замените на нужный)
        await flutterTts.setPitch(1.0); // Установка тона (по умолчанию равно 1.0)
        await flutterTts.speak(response); // Воспроизведение текста в голосовом формате
    }

    @override
    Widget build(BuildContext context) {
        return Scaffold(
            appBar: AppBar(
                    title: Text("Ваша страница"),
        ),
        body: Center(
        child: RaisedButton(
        child: Text("Воспроизвести ответ"),
        onPressed: () {
        String response = "Здесь ваш ответ для воспроизведения";
        speakResponse(response);
    },
        ),
        ),
        );
    }
}
class _MagicBallAppState extends State<MagicBallApp> {
    String _answer = '';

    void _getAnswer() async {
        final response = await http.get('https://api.example.com/answer');

        if (response.statusCode == 200) {
            final data = jsonDecode(response.body);
            setState(() {
                _answer = data['answer'];
            });
        } else {
            setState(() {
                _answer = 'Error fetching answer';
            });
        }
    }

    @override
    Widget build(BuildContext context) {
        return Scaffold(
            appBar: AppBar(
                    title: Text('Магический шар'),
        ),
        body: Center(
        child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
        Text(
            '$_answer',
            style: TextStyle(fontSize: 24),
        ),
        SizedBox(height: 20),
        RaisedButton(
            onPressed: _getAnswer,
            child: Text('Получить ответ'),
        ),
        ],
        ),
        ),
        );
    }
}
// Функция для обработки события тряски
function onShake() {
    // Тут можно выполнить запрос к серверу
    // используя AJAX-запрос или фреймворк типа Fetch
    // Пример с использованием Fetch:
    fetch('https://your-api-url.com', {
        method: 'POST',
        body: JSON.stringify({ shake: true }) // Передача данных о тряске
    })
        .then(response => response.json())
    .then(data => {
        // Обработка ответа от сервера
        console.log(data);
    })
    .catch(error => {
        // Обработка ошибки
        console.error('Error:', error);
    });
}

// Создаем слушатель для события тряски
window.addEventListener('shake', onShake, false);


void main() {
    runApp(MagicBallApp());
}

class MagicBallApp extends StatelessWidget {
    @override
    Widget build(BuildContext context) {
        return MaterialApp(
            home: Scaffold(
                    backgroundColor: Colors.blue,
        appBar: AppBar(
        title: Text('Магический шар'),
        backgroundColor: Colors.blue[900],
        ),
        body: MagicBall(),
        ),
        );
    }
}

class MagicBall extends StatefulWidget {
    @override
    _MagicBallState createState() => _MagicBallState();
}

class _MagicBallState extends State<MagicBall> {
    int ballNumber = 1;

    void rollBall() {
        setState(() {
            ballNumber = Random().nextInt(5) + 1;
        });
    }

    @override
    Widget build(BuildContext context) {
        return Center(
            child: FlatButton(
                    child: Image.asset('images/ball$ballNumber.png'),
        onPressed: () {
        rollBall();
    },
        ),
        );
    }
}
// Для того чтобы приложение работало на десктопе, потребуется добавить пакет flutter-desktop-embedding и изменить настройки проекта


