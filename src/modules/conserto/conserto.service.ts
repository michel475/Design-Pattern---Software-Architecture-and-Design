

export class ConsertoService {
    constructor(){

    }   

    async RegistrarConserto(nome: string, cpf: string, maquinaTipo: string, descricao: string, dataConserto: string,) {
        const servico = ConsertoFacade({nome,cpf,maquinaTipo,descricao,dataConserto});
    }
}