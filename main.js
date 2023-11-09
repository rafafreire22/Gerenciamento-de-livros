document.getElementById('descricao').addEventListener('submit', descricao);
function descricao(event) {
    event.preventDefault();
    const descricao = document.getElementById('descricao').value;
    const isbn = document.getElementById('isbn').value;
    fetch('http://localhost:8080/jogos', {
        method: 'POST',
        Headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ descricao, isbn}),
    })
    .then(response => response.json())
    .then(data => {
        alert('Livro cadastrado com sucesso!!!');
        document.getElementById('descricao').reset();
    })
    .catch(error => {
        console.error('Erro ao cadastrar livro:', error);
    });
}
function pesquisarLivro(){
    const seachId = document.getElementById('seachId').value;
    fetch('http://localhost:8080/jogos/${searchId}')
    .then(response => {
        if (response.status ===404){
            return Promise.reject('Livro não encontrado');
        }
        return response.json();
    })
    .then(data => {
        const resultadoPesquisa = document.getElementById('resultadoPesquisa');
        resultadoPesquisa.innerHTML = `
        <h3>ID: ${data.id}</h3>
        <p>Descrição: ${data.descricao}</p>
        <p>Isbn: ${data.isbn}</p>
        `;
    })
    .catch(error => {
        console.error('Error ao pesquisar livro:', error);
        const resultadoPesquisa = document.getElementById('resultadoPesquisa');
        resultadoPesquisa.innerHTML = 'Livro não encontrado.';
    });
}



    
