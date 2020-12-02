# TheBank
> Atualizando [Trallerd Bank](https://github.com/trallerd/trallerdBank) usando [ROOM](https://developer.android.com/training/data-storage/room)

- Utilizando [ROOM](https://developer.android.com/training/data-storage/room) e [SQLite](https://developer.android.com/training/data-storage/sqlite?hl=pt-br). Agora toda a aplicação trabalha com dados "reais" e não apenas interfaces com dados estáticos (login, extrato, saldo, enviar dinheiro, ...).
- A tela de login tem uma opção para cadastrar um novo usuário (usuário, senha e confirmar senha). Cadastrar o usuário no banco de dados.
- Uma vez logado, toda vez que o usuário reabrir o aplicativo, o app já inicia a tela com o usuário logado, ao invés de mostrar a tela de login (usando [SharedPreferences](https://developer.android.com/reference/android/content/SharedPreferences)).
- O usuário pode deslogar.
- Cada usuário só pode consultar os seus próprios lançamentos bancários, bem como só pode criar lançamentos para si.
- Possibilidade de "Receber dinheiro", usando os mesmos Fragments do "Enviar dinheiro", apenas customizando as strings e ações.
- A tela do extrato mostra os envios e recebimentos utilizando um RecyclerView, com os itens devidamente formatados e organizados. Utilizar cores para diferenciar receitas e despesas. E data (devidamente formatada).
- A edição deve ocorre dentro do próprio item no RecyclerView. Posteriormente esta informação aparece junto ao registro, quando houver.
- A tela de saldo mostra organizadamente mostrar o total de receitas, total de despesas e saldo do usuário logado.

### About me
[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/fagnerpsantos)](https://github.com/Trallerd)
[![Twitter Badge](https://img.shields.io/badge/-Twitter-1ca0f1?style=flat-square&labelColor=1ca0f1&logo=twitter&logoColor=white&link=https://twitter.com/trallerd)](https://twitter.com/trallerd)
[![Youtube Badge](https://img.shields.io/badge/-YouTube-ff0000?style=flat-square&labelColor=ff0000&logo=youtube&logoColor=white&link=https://www.youtube.com/channel/UCHmlPQF6AVr3y7fj7TE-7Hw)](https://www.youtube.com/channel/UCHmlPQF6AVr3y7fj7TE-7Hw)
