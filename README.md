# SignalScope

**Monitore, analise e visualize a qualidade da sua conexão móvel.**

O **SignalScope** é um aplicativo Android em desenvolvimento para monitorar a qualidade da rede móvel, registrar medições ao longo do tempo e visualizar dados como operadora, tipo de rede, intensidade do sinal, localização e histórico de conexão.

A proposta é evoluir o projeto como um produto real, aplicando boas práticas modernas do ecossistema Android.

---

## Status do projeto

🚧 **Em desenvolvimento — Dia 2 do roadmap**

Etapa atual:

- Projeto Android criado
- Jetpack Compose configurado
- Material 3 configurado
- Estrutura inicial de pacotes criada
- Git iniciado
- Configuração inicial de Navigation, Hilt e Version Catalog em andamento

---

## Problema

Hoje, quando a internet móvel está ruim, o usuário normalmente sabe apenas que a conexão está instável.

Ele não consegue visualizar facilmente:

- onde o sinal é ruim;
- qual operadora apresenta melhor cobertura;
- quando a conexão caiu;
- como a qualidade mudou ao longo do dia;
- qual tecnologia está sendo usada, como 4G ou 5G.

---

## Solução

O SignalScope tem como objetivo monitorar a qualidade da conexão móvel e gerar um histórico de medições com estatísticas e visualização em mapa.

Com isso, o usuário poderá acompanhar a qualidade da rede de forma mais clara e entender melhor o comportamento da conexão em diferentes locais e horários.

---

## Público-alvo

- Usuários comuns
- Técnicos de telecomunicações
- Estudantes
- Empresas
- Motoristas
- Pessoas que viajam com frequência

---

## Tecnologias planejadas

- Kotlin
- Jetpack Compose
- Material 3
- MVVM
- Clean Architecture
- Hilt
- Room
- Coroutines
- StateFlow
- WorkManager
- Google Maps
- DataStore
- Retrofit
- Firebase Crashlytics

---

## Funcionalidades planejadas

### Dashboard

Tela principal do aplicativo, com informações como:

- operadora;
- tipo da rede;
- intensidade do sinal;
- qualidade da conexão;
- última atualização;
- status da internet.

### Histórico

Listagem das medições realizadas, exibindo:

- horário;
- operadora;
- tipo da rede;
- intensidade do sinal.

### Estatísticas

Resumo dos dados coletados, incluindo:

- média do sinal;
- valor máximo;
- valor mínimo;
- quantidade de medições;
- tempo conectado.

### Mapa

Visualização geográfica dos pontos coletados, com base em:

- localização;
- intensidade do sinal;
- histórico de medições.

### Configurações

Tela para o usuário definir preferências como:

- intervalo de medição;
- salvar ou não localização;
- tema do aplicativo.

### Exportação

Exportação dos dados coletados em formato:

- CSV.

### Coleta em segundo plano

Uso de WorkManager para permitir coleta periódica mesmo com o aplicativo fechado.

---

## Estrutura inicial do projeto

```text
app/
└── src/
    └── main/
        └── java/
            └── com/
                └── laiana/
                    └── signalscope/
                        ├── core/
                        ├── data/
                        ├── di/
                        ├── domain/
                        ├── presentation/
                        │   ├── dashboard/
                        │   ├── history/
                        │   ├── maps/
                        │   ├── statistics/
                        │   └── settings/
                        ├── ui/theme/
                        └── MainActivity.kt
```

---

## Arquitetura planejada

O projeto será organizado com base em princípios de **MVVM** e **Clean Architecture**.

```text
presentation/
    telas, estados de UI e ViewModels

domain/
    modelos, regras de negócio e casos de uso

data/
    banco local, fontes remotas e implementação dos repositórios

core/
    utilitários, constantes e recursos compartilhados

di/
    módulos de injeção de dependência com Hilt
```

---

## Modelo de dados planejado

Entidade principal:

```text
SignalMeasurement
```

Campos previstos:

```text
id
timestamp
operator
networkType
signalDbm
signalLevel
latitude
longitude
ping
download
upload
```

---

## Roadmap

### Semana 1 — Fundamentos Android

- Dia 1: criação do projeto, Compose, Material 3, Git e estrutura de pastas
- Dia 2: Navigation, Hilt e Version Catalog
- Dia 3: tema e componentes reutilizáveis
- Dia 4: estudo do TelephonyManager e criação do NetworkMonitor
- Dia 5: captura de operadora e tipo de rede
- Dia 6: exibição dos dados na Dashboard
- Dia 7: refatoração

### Semana 2 — Arquitetura

- Models
- Repository
- Use Cases
- ViewModel
- StateFlow
- estados da tela
- testes básicos

### Semana 3 — Persistência

- Room
- DAO
- repositório local
- salvar medições
- tela de histórico
- filtros
- pesquisa de medições

### Semana 4 — Localização

- GPS
- permissões
- Google Maps
- marcadores
- heatmap opcional
- integração completa

### Semana 5 — Diferenciais

- WorkManager
- exportação CSV
- Dark Mode
- DataStore
- melhorias de UI
- README profissional
- publicação no GitHub

---

## Como executar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/signalscope.git
```

2. Abra o projeto no Android Studio.

3. Aguarde a sincronização do Gradle.

4. Execute o aplicativo em um emulador ou dispositivo físico Android.

---

## Requisitos de desenvolvimento

- Android Studio
- Kotlin
- Gradle
- Android SDK instalado
- Emulador Android ou dispositivo físico

---

## Observação sobre permissões

Nas próximas etapas, o projeto utilizará permissões relacionadas a rede e localização, como:

- acesso ao estado da rede;
- acesso à localização;
- execução de tarefas em segundo plano.

Essas permissões serão adicionadas conforme as funcionalidades forem implementadas.

---

## Objetivo de aprendizado

Este projeto tem como objetivo consolidar conhecimentos em desenvolvimento Android moderno, incluindo:

- criação de interfaces com Jetpack Compose;
- arquitetura MVVM;
- Clean Architecture;
- injeção de dependência com Hilt;
- persistência local com Room;
- programação assíncrona com Coroutines e Flow;
- tarefas em background com WorkManager;
- integração com mapas;
- uso de APIs nativas do Android relacionadas a telecomunicações.

---

## Evoluções futuras

- Comparação entre operadoras
- Teste de velocidade com ping, download e upload
- Compartilhamento de relatórios
- Dashboard web
- Login com Firebase
- Inteligência Artificial para prever regiões com baixa cobertura

---

## Autor

Desenvolvido por **Laiana de Pinho Cavalcante**.

Projeto criado como aplicação Android de portfólio com foco em telecomunicações, dados e boas práticas modernas de desenvolvimento mobile.
