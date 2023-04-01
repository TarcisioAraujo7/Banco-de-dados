from flask import Flask, jsonify, request 
from pessoa import Pessoa
import datetime 

app = Flask(__name__)

banco_dados = [Pessoa(123456789, "Agatha", datetime.date(2018,5,18))]

@app.route('/usuarios/<int:cpf>', methods=['GET'])  # type: ignore
def consultar_usuario(cpf):
    for usuario in banco_dados:
        if usuario.cpf == cpf:
            print(usuario)
            return jsonify(usuario.retorne_dict())
    
    return "Usuario não encontrado"

@app.route('/usuarios/cadastro', methods=['POST']) 
def cadastrar_usuario():

    novo_usuario = request.get_json()
    
    for usuario in banco_dados:
        if usuario.cpf == novo_usuario['cpf']:
            return 'Ja existe um usuario com este cpf no sistema!'

    data_nasc = (novo_usuario['data'])
    data_formatada = datetime.date(data_nasc["ano"],data_nasc["mes"], data_nasc["dia"])

    novo_usuario = Pessoa(novo_usuario['cpf'], novo_usuario['nome'], data_formatada)
    
    banco_dados.append(novo_usuario)

    saida = []
    for usuario in banco_dados:
        saida.append(usuario.retorne_dict())

    return saida
    
app.run(port=5000, host='localhost')