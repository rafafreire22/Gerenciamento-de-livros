document.getElementById('descricao').addEventListener('submit', descricao);
function descricao(event) {
    event.preventDefault();
    const descricao = document.getElementById('descricao').value;
    const isbn = document.getElementById('isbn').value;
    fetch('http://localhost:8080/Livros', {
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
    fetch('http://localhost:8080/Livros/${searchId}')
    .then(response => {
        if (response.status ===404){
            return Promise.reject('Livro não encontrado');
        }
        return response.json();
    })
    .then(data => {
        result = 1;
        document.getElementById('descricao').value = `${data.descricao}`;
        document.getElementById('isbn').value = `${data.isbn}`;
    })
    .catch(error => {
        console.error('Error ao pesquisar livro:', error);
        const resultadoPesquisa = document.getElementById('resultadoPesquisa');
        resultadoPesquisa.innerHTML = 'Livro não encontrado.';
    });
}



    
