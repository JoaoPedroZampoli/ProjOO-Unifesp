# Exercício 3.2
## Projeto de Jornal utilizando Composite

- a) Escreva uma interface Publicação que trate de forma
equivalente coleções (compostas de outras publicações, como
revistas, jornais, cadernos) e artigos individuais indivisíveis.

- b) Escreva uma aplicação de testes que construa o diagrama de
objetos acima e
• Imprima o número de publicações e de artigos
• Imprima o conteúdo de toString() que deve imprimir o toString de cada
publicação (deve conter o nome e, se for artigo, o autor).

#### Especificações da imagem do Slide:
- Coleção: publicacoes:List
- Coleção(nome:String): getPublicacoes():List, addPublicacao(Satelite), toString():String

- Artigo: Artigo(nome:String, autores: String[]), toString():String