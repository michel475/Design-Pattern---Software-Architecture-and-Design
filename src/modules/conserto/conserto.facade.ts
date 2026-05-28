import { DispositivoFactory } from "./dispositivo-factory"
import { Maquina } from "./maquina"

type Conserto = {
    nome: string;
    cpf: string;
    dispositivo: Maquina;
}

let consertos: Conserto[] = [];

type Input = {
    nome;
    cpf;
    maquinaTipo;
    descricao;
    dataConserto;
}

export class ConsertoFacade {
    constructor(){
        
    }   

    async RegistrarConserto(data: Input) {
        const dispFac = DispositivoFactory.create(data.nome, data.cpf, data.maquinaTipo, data.descricao, data.dataConserto);
        const conserto: Conserto = {nome:data.nome,cpf:data.cpf,dispositivo:dispFac};
        consertos.push(conserto);
        return conserto;
    }

    async ListarConsertos() {
        return consertos;
    }
}