API REST, UORFOOD
UORFOOD surgiu apos a incentiva diminuir o desperdiço de alimentos e acabar com a fome no mundo, esta API sera parte da solução.

SOLUÇÃO
Para atingir esse objetivo, aplicação completa sera software de recompensas, quanto mais pessoa doar alimentos, mais pontos ira acumular. Seus pontos podem ser posteriormente trocados por recompensas ou em lojas conveniadas por produtos.
API sera responsável por persistir os dados necessários dos usuários, seus pontos e os produtos doados

MOTIVACAO
Criar uma API para ser consumida no front end,com persistência de dados no Banco da Oracle SQL
API com 3 endpoints Users,Products,Company
Os 3 endpoints precisam possuir recursos dos verbos comuns em uma aplicação rest. GET,POST,DELETE e PUT
FETATURES
Usamos projeto de software DAO
Polimorfismo, classe Service chama os métodos da classe que implementa a interface DAO é retorna para classe Controller
Objetivo de a classe Serivce é obter as informações necessárias que classe Controller precisa.
Classe que implementa a interface DAO, responsável por toda logica do banco(SELECT, UPDATE, DELTE, INSERT).
Controller faz as requestes com o servidor é retorna para camada service
Controller recebe as anotations(GET, PUT,DELTE,EDIT,POST).
PRODUCTS E COMPANY
Esses duas entidades no banco possuem relação direta a entidade User
Não é possível possuir empresa ou produtos sem usuários.
Para fazer essa relação estamos usando o identificador único do usuário(user_id)
