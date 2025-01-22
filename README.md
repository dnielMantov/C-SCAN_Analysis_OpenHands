# C-SCAN Analysis

Repositório para versionamento de código utilizado no relatório da disciplina de Sistemas Operacionais sobre o algoritmo C-SCAN.
É possível fornecer as seguintes características do disco como parâmetros:

- Tamanho do setor
- Número de trilhas
- Número de setores por trilhas
- Taxa de transferência
- Tempo de busca (seek time)
- Tempo de rotação (rotation time)
- Setor inicial

Clique [aqui](https://docs.google.com/document/d/1yB46UXTxB3JjAze1ii0SP1VVJovRRW1g5hddzQgeCr4/edit?usp=sharing) para acessar o relatório.

# Implementação

O algoritmo foi implementado na linguagem Java, seguindo conceitos de orientação a objetos e utilizando bibliotecas de estruturas de dados da linguagem como `java.util.ArrayList`.
É utilizado o padrão à direita, buscando os setores realizando um movimento da esquerda para a direita.

Para comparações entre requisições randômicas e lineares e mais detalhes a respeito do funcionamento de um disco e do algoritmo, acesse o relatório do projeto.

# Utilização

Para executar o algoritmo, acesse a classe `./src/cscan/RunCSCAN.java`, modifique os parâmetros do disco e do sorteio randômico de requisições a seu critério e em seguida execute a
função `main`.

O algoritmo consegue suportar até uma faixa de 14000 setores requisitados ao mesmo tempo. Para testar, modifique os parâmetros do sorteio aleatório de requisições na classe `RunCSCAN`
(não recomendado, utilize valores menores).

> Caso a execução fique em loop infinito, muito provavelmente os valores fornecidos como parâmetros não estão corretos ou o usuário quis se aventurar com mais requisições do que o permitido.

## Saída formatada

A saída no terminal segue o modelo mostrado abaixo, exibindo as requisições sorteadas, a ordem de acesso a cada setor com base nos parâmetros de disco, a posição inicial do cabeçote
e o tempo total em milisegundos de toda a requisição.

```
Requests:
[7, 35, 1, 22, 19, 7, 16, 30, 1, 7, 3, 26, 14, 18, 33, 24, 15, 29, 25, 30]

Accessed sectors:
[33, 35, 24, 25, 26, 29, 30, 30, 7, 7, 7, 1, 1, 3, 15, 16, 18, 19, 22, 14]
Initial head position: 31
13,95 ms
```

# Para os alunos

Este trabalho obteve uma nota 9.0 de 10.0. Podem utilizar o algoritmo e o documento como modelo para seus relatórios, mas, claro, "copia só não faz igual". Uma dica é mudar a linguagem, não usem Java,
utilizem alguma linguagem de script mais simples como Python. A respeito dos gráficos, fiquem livres para escolher entre uma biblioteca de plotagem de gráfico da sua linguagem favorita ou usar as tabelas
do Google Sheets como utilizei, são bem customizáveis e fáceis de utilizar.
