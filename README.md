Conversor de Moedas – Kotlin + Jetpack Compose

Aplicativo desenvolvido como atividade da disciplina **Programação para Dispositivos Móveis – UNIVALI**, seguindo a arquitetura recomendada pela Google e consumindo dados da API de câmbio **Frankfurter**.

Funcionalidades
- Listar moedas disponíveis  
- Selecionar moeda de origem e destino  
- Digitar um valor para conversão  
- Consumir as rotas `/currencies` e `/latest` da API  
- Exibir o valor convertido em tempo real  
- Interface construída com Jetpack Compose  
- Arquitetura em camadas (data, domain, ui)

Arquitetura do Projeto
/app  
 └── /src  
      └── /main  
           └── /java/seupacote  
                ├── MainActivity.kt  
                ├── /data  
                │     ├── CurrencyRepository.kt  
                │     └── /remote  
                │           ├── ApiService.kt  
                │           ├── RatesResponse.kt  
                ├── /domain  
                │     └── CurrencyUseCase.kt  
                └── /ui  
                      ├── MainViewModel.kt  
                      ├── /components  
                      │      └── DropdownMenuCurrency.kt  
                      └── /screen  
                             └── HomeScreen.kt  

API Utilizada
API Frankfurter — https://www.frankfurter.app/docs/

Tecnologias
- Kotlin  
- Jetpack Compose  
- ViewModel + StateFlow  
- Retrofit  
- Gson  
- Material 3  
- Coroutines  

Como rodar
1. Baixar/clonar esse repositório  
2. Abrir no Android Studio  
3. Sincronizar o Gradle  
4. Rodar no emulador ou dispositivo físico  

Referências
- https://developer.android.com  
- https://www.frankfurter.app/docs/  
- https://m3.material.io  
- https://developer.android.com/jetpack/compose

Autor
Erik Malcher  
UNIVALI – Programação para Dispositivos Móveis
