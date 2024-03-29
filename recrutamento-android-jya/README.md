# Prova de Android
## Objetivo

Voc� deve desenvolver uma aplica��o Android Nativa em Kotlin que consuma a API
do Github Issues ( https://developer.github.com/v3/issues/ ), usando como base o reposit�rio
do kotlin ( https://github.com/JetBrains/kotlin ).

## O aplicativo deve conter

* Uma tela com a lista de issues do reposit�rio
( https://api.github.com/repos/JetBrains/kotlin/issues ). Cada item da lista deve
conter os seguintes elementos:
    * T�tulo do issue
    * Estado do issue (ABERTO, FECHADO)
* Uma tela mostrando os detalhes do issue que foi selecionado na lista, que deve
conter os seguintes elementos:
    * T�tulo do issue
    * Texto de Descri��o do issue
    * Avatar do usu�rio que criou a issue
    * Data de cria��o
    * Um bot�o que abre o browser com o link issue do site do github

## Requisitos obrigat�rios

* Kotlin
* RxJava 2
* Koin (preferencialmente) ou Dagger2
* Testes Unit�rios (de prefer�ncia com JUnit / MockK)
* OkHttp3 (preferencialmente) ou Retrofit 2

## Requisitos opcionais

* MVVM
* AndroidX
* Coroutines
* LiveData / Navigation / Action Components

## Pontos de avalia��o

* Como voc� organiza seus arquivos, m�todos, nomeia vari�veis, lida com o seu
c�digo como um todo s�o pontos observados. 
* Seja cuidadoso, utilize boas pr�ticas e padr�es.
* Siga o guideline do Material Design, bem como respeite as boas pr�ticas do
Kotlin. Codifique como voc� gostaria de trabalhar.
