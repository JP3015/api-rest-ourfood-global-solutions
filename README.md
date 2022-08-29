### API REST, OURFOOD
OURFOOD surgiu com o propósito de diminuir o desperdício de alimentos e reduzir a fome no mundo, esta API será parte da solução.

## SOLUÇÃO
Para atingir esse objetivo a aplicação será um software de recompensas, quanto mais a pessoa doar alimentos, mais pontos irá acumular. Seus pontos podem ser posteriormente trocados por recompensas ou em produtos conveniados por lojas.</br>
API será responsável por persistir os dados necessários dos usuários, seus pontos e os produtos doados.

## MOTIVACAO
- Criar uma API para ser consumida no front end, com persistência de dados no Banco da Oracle SQL.
- API com 3 endpoints Users, Products, Company.
- Os 3 endpoints precisam possuir recursos dos verbos comuns em uma aplicação rest: GET, POST, DELETE e PUT.

## FETATURES
- Usamos projeto de software DAO.
- Classe Service chama os métodos da classe que implementa a interface DAO e retorna para classe Controller.
- O objetivo da classe Serivce é obter as informações necessárias que a classe Controller precisa.
- Classe que implementa a interface DAO, responsável por toda lógica do banco(SELECT, UPDATE, DELTE, INSERT).
- Controller faz as requests com o servidor e retorna para a camada service.
- Controller recebe as annotations(GET, PUT,DELTE,EDIT,POST).

## PRODUCTS E COMPANY
- Essas duas entidades no banco possuem relação direta a entidade User.
- Não é possível possuir empresa ou produtos sem usuários.
- Para fazer essa relação estamos usando o identificador único do usuário(user_id)



