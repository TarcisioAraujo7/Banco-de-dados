class Pessoa:
    def __init__(self, cpf, nome, data):
        self.cpf = cpf
        self.nome = nome
        self.data = data

    def retorne_dict(self):
        return {'cpf' : self.cpf, 'nome' : self.nome, 'data' : self.data}
