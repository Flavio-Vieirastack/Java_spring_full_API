# Api completa feita em java e spring boot

##### Casos de uso

A API foi feita para atender as demandas de uma marketplace e por tanto tem as seguintes funcionalidades

##### Funcionalidades de:

* CRUD
* Atenticação JWT
* Envio de imagens a amazon s3
* Envio de email via Gmail
    * Com MockEmailService + Logger
    * Padões Strategy
    * Template Methods
* Validações com Bean validation
* Tratamento de excessões personalizadas
* Paginação

##### Foram usados:

* Banco de dados H2 para testes
* Mysql como banco principal
* Possibilidade de troca para banco não relacional

#### Api de código livre sinta-se a vontade para usar e modificar de acordo com sua necessidade

# Casos de uso
**Atores** Cliente  
**Interessados** Departamento de vendas  
**Precondições** Cliente cadastrado  
Pós-condições -
* Visão geral
Este caso de uso consiste no processo de escolha de produtos e
fechamento de pedido por parte do cliente.

# Cenário Principal de Sucesso
1. [OUT] O sistema informa os nomes de todas categorias ordenadamente.
2. [IN] O cliente informa um trecho de nome de produto desejado, e seleciona as categorias
desejadas.
3. [OUT] O sistema informa nome e preço dos produtos que se enquadram na pesquisa.
4. [IN] O cliente seleciona um produto para adicionar ao carrinho de compras (*).
5. [OUT] O sistema exibe o carrinho de compras (**).
6. [IN] O cliente informa que deseja fechar o pedido, e informa seu usuário e senha.
7. [OUT] O sistema informa logradouro, numero, complemento, bairro, cep, cidade e estado
de todos endereços do cliente.
8. [IN] O cliente seleciona um endereço para entrega.
9. [OUT] O sistema exibe as formas de pagamento.
10. O cliente escolhe uma das opções:
    * 10.1. Variante: Pagamento com boleto
    *  10.2. Variante: Pagamento com cartão
11. [OUT] O sistema informa a confirmação do pedido (***).

# Cenários Alternativos: Variantes
* Variante 5.1: Nova busca
    * 5.1.1 [IN] O cliente informa que deseja realizar uma nova busca.
    * 5.1.2 Vai para 1.
    * Variante 10.1: Pagamento com boleto
    * 10.1.1. [IN] O cliente informa que deseja pagar com boleto.
* Variante 10.2: Pagamento com cartão
    * 10.2.1. [IN] O cliente informa que deseja pagar com cartão e informa a quantidade de
parcelas.

# Cenários Alternativos: Exceções
Variante 6.1: Falha na autenticação
* 6.1.1 [IN] O sistema informa mensagem de usuário ou senha inválidos.
* 6.1.2 Vai para 6.

# Informações complementares

* (*) Quando um produto já existente no carrinho é selecionado, a quantidade deste produto no
carrinho deve ser incrementada, caso contrário o produto é adicionado ao carrinho com
quantidade 1.
* (**) As informações do carrinho de compras são: nome, quantidade e preço unitário de cada
produto (não será dado desconto), o subtotal de cada item do carrinho, e o valor total do
carrinho.
* (***) As informações da confirmação do pedido são: número, data e horário do pedido, valor
total do pedido, bem como o tipo e estado do pagamento (Pendente). Caso o pagamento
seja com boleto, informar a data de vencimento, e caso o pagamento seja com cartão,
informar o número de parcelas.