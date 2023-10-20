![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/ad39c312-628e-4649-a8d3-1b1c0c44dfe9)PjBL3 - Hash Table (Arthur Correia Brígido)

A aplicação demonstra o funcionamento de uma tabela Hash. O algoritmo é composto por funções de busca, inserção, exlusão e impressão dos elementos. A tabela Hash é uma tabela de espalhamento que associa chaves de pesquisa a valores. Ela faz uma busca a partir de uma chave simples e obtem um valor desejado.

. Classe "Hash": nela estão as principais funções de implementação da aplicação e os dois tratamentos de colisão.

  1. "insert" : insere um aluno na tabela hash (sondagem linear). 
  
  ![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/f103669d-80c1-4413-87da-6cb76282bfe8)

  1.1. "insert auxiliar" : insere o aluno em uma posição vazia na tabela principal. Se todas as posições principais estiverem ocupadas, tenta inserir o aluno em uma lista encadeada (bucket) associada à posição da chave original.
  
  ![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/d343c53d-377c-4592-910f-6000338c6b23)

  1.2. "insertInBucket" : insere um aluno na tabela hash (encadeamento). Se a posição estiver vazia, o aluno é inserido diretamente. Caso contrário, o código percorre a lista encadeada até encontrar o final e, em seguida, insere o aluno.

  ![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/e985e7ba-bc26-4230-b451-84e0e1aa65af)

  2. "delete": permite remover um aluno da tabela hash (sondagem linear).

  ![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/76044647-eaeb-4037-b040-9758cccf01b5)

  2.1. "delete auxiliar" : Busca e deleta um aluno com base em uma chave dada na tabela principal. Se não encontrado na tabela principal, busca e deleta o aluno no bucket associado.

  ![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/c3bbf5e7-f0d8-4779-aeb0-aa15d81a18f6)

  2.2. "deleteInBucket" : permite remover um aluno da tabela hash (encadeamento). Ele verifica o nó na posição dada e os nós subsequentes na lista encadeada para encontrar e remover o aluno.

  ![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/4455772b-724a-4e08-98d7-8579f9b21693)

  3. "search": permite a realização de uma busca por um aluno na tabela hash

  ![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/85280e7c-3634-4a91-b549-bbae9aec75ca)

  3.1. "search auxiliar": Busca a chave do aluno na tabela principal usando sondagem linear. Se não for encontrado na tabela principal, procura no bucket associado. Retorna a chave do aluno se encontrado; caso contrário, retorna -1.

  ![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/4bb09c1f-7a9a-4e2d-b7a3-7eaadb76786c)

  3.2. "searchInBucket": permite a realização de uma busca por um aluno na tabela hash. Ele percorre a lista encadeada e retorna o aluno se encontrado. Se não for encontrado, retorna null. 
  
  ![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/c70e021b-081c-4ad1-b06c-9e39802c4069)

  4. "print": permite imprimir o conteúdo da tabela hash

  ![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/8380d960-2860-4232-8d26-8c6e60cacfbb)

  5. "getAlunoKey": Retorna a chave do aluno na tabela hash.

  ![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/0a13d2c3-c242-4cd9-90ed-943ef5f96f19)

. Classe "Aluno": inicializa a matrícula como -1 quando nenhum valor é especificado, permite definir uma matrícula quando o objeto é criado com um valor inteiro e um método getMatricula() que permite obter a matrícula de um objeto Aluno. 

![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/6ef8a597-4dd8-4b98-beef-f522535d18fc)

. Classe "Main": Responsável por criar, modificar e visualizar uma tabela hash de aluno. Nela são utilizadas todas as funções implementadas na aplicação: "insert", "search", "delete" e "print".

![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/c3f09456-7e13-477b-a302-f079a2057ad2)

. Classe "HashNode" : Foi a classe adicionada ao código com correções e representa um nó em uma estrutura de lista encadeada, utilizado no método de encadeamento para tratar colisões na tabela hash.

![image](https://github.com/ArthurCorreiaBrigido/Hash-Table/assets/51636263/569568a3-0d10-4a0f-addf-f59a08ddf5b0)

