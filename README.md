# Sistema de Locadora de Veículos

## 1. Integrantes

- **Integrante 1:** Carlos Daniel de Oliveira Santos
- **Integrante 2:** Roger Augusto Camargo de Faria
- **Integrante 3:** Weber Júnior Lopes de Azevedo

## 2. Descrição do problema

O projeto consiste no desenvolvimento de um sistema de gerenciamento para uma locadora de veículos, utilizando a linguagem Java e os conceitos de Programação Orientada a Objetos (POO).

O sistema tem como objetivo facilitar o controle de clientes, veículos e locações, permitindo cadastrar informações, consultar registros, realizar aluguéis e controlar a devolução dos veículos.

A aplicação funciona por meio de um menu interativo no terminal, no qual o usuário escolhe as operações que deseja executar.

## 3. Funcionalidades

O sistema possui as seguintes funcionalidades:

- **Cadastro de clientes:** registra nome, CPF, CNH e idade do cliente.
- **Cadastro de veículos:** registra modelo, marca, placa, ano de fabricação e valor da diária.
- **Realização de locações:** permite selecionar um cliente cadastrado e um veículo disponível, informando a quantidade de dias do aluguel.
- **Listagem de clientes:** exibe os clientes cadastrados.
- **Listagem de veículos:** exibe os veículos cadastrados.
- **Listagem de locações:** apresenta os dados das locações, incluindo cliente, veículo, quantidade de dias, valor total e situação.
- **Devolução de veículos:** permite registrar a devolução e calcular uma possível multa por atraso.
- **Remoção de clientes:** permite remover um cliente cadastrado.
- **Remoção de veículos:** permite remover um veículo cadastrado, desde que esteja disponível.

O sistema também realiza verificações para evitar o cadastro de clientes com CPF ou CNH duplicados e de veículos com placas repetidas.

## 4. Tecnologias utilizadas

- **Linguagem:** Java.
- **Paradigma:** Programação Orientada a Objetos (POO).
- **Estruturas de dados:** `ArrayList` para armazenar clientes, veículos e locações.
- **Entrada de dados:** classe `Scanner`.
- **Ambiente de desenvolvimento:** NetBeans.
- **Controle de versão:** Git e GitHub.

## 5. Instruções para executar

### Pré-requisitos

- Ter o Java JDK instalado.
- Ter uma IDE compatível com Java, como o NetBeans, ou utilizar o terminal.
- Ter acesso aos arquivos do projeto.

### Executando pelo NetBeans

1. Baixe ou clone o repositório do projeto.
2. Abra o NetBeans.
3. Importe ou abra o projeto.
4. Verifique se os arquivos `App.java`, `Cliente.java`, `Veiculo.java`, `Locacao.java` e `Locadora.java` estão no pacote `Locadora`.
5. Execute a classe `App.java`.
6. Utilize o menu exibido no terminal para acessar as funcionalidades do sistema.

### Executando pelo terminal

Caso os arquivos estejam organizados em uma pasta chamada `Locadora`, com o diretório atual sendo a pasta que contém essa pasta, execute:

```bash
javac Locadora/*.java
java Locadora.App
```

## 6. Exemplo de utilização

Ao executar o programa, o usuário visualizará um menu semelhante ao seguinte:

```text
Qual opção você deseja?
1 - Cadastrar um Cliente
2 - Cadastrar um Veiculo
3 - Fazer uma Locação
4 - Listar Cliente
5 - Listar Veículo
6 - Listar Locação
7 - Devolver Veículo
8 - Remover um Cliente do Sistema
9 - Remover um Carro do Sistema
10 - Remover uma Locação
0 - Para Sair

Número da opção:
```

### Exemplo: realizar uma locação

1. Escolha a opção `1` para cadastrar um cliente.
2. Informe os dados solicitados, como nome, CPF, CNH e idade.
3. Escolha a opção `2` para cadastrar um veículo.
4. Informe modelo, marca, placa, ano e valor da diária.
5. Escolha a opção `3` para realizar uma locação.
6. Informe o CPF do cliente cadastrado.
7. Informe a placa do veículo disponível.
8. Informe a quantidade de dias da locação.

O sistema calculará o valor total com base no valor da diária e na quantidade de dias informada.

**Exemplo de cálculo:**

- Valor da diária: R$ 100,00.
- Quantidade de dias: 3.
- Valor total da locação: R$ 300,00.

Ao final, o sistema exibirá as informações da locação realizada.

## 7. Divisão das responsabilidades da equipe


**Carlos Daniel**: desenvolvimento da classe Cliente, implementação do cadastro e das consultas de clientes, desenvolvimento da classe Locacao e implementação das operações de aluguel e devolução. Também contribuiu com sugestões e ajustes para melhorar a integração entre as classes e garantir a compatibilidade das funcionalidades com o restante do sistema.

**Roger Augusto**: desenvolvimento da classe Veiculo, incluindo os atributos e métodos relacionados ao cadastro, à listagem e ao controle de disponibilidade dos veículos. Também foi responsável pela implementação dos métodos de verificação, utilizados para evitar o cadastro de informações duplicadas, como CPF, CNH e placa de veículos.

**Weber Júnior**: desenvolvimento da classe Locadora, responsável pelo gerenciamento das listas de clientes, veículos e locações, além da implementação dos métodos de gerenciamento e da organização do menu principal na classe App.



## 8. Considerações finais

O projeto permite aplicar na prática os conceitos de Programação Orientada a Objetos em Java, como classes, objetos, atributos privados, métodos, encapsulamento e relacionamento entre classes.

Além disso, o desenvolvimento contribui para o aprendizado de estruturas de dados, validação de informações, organização do código e utilização de ferramentas de controle de versão.
