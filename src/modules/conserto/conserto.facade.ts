import { DispositivoFactory } from "./dispositivo-factory"
import { Maquina } from "./maquinas/maquina"

type Conserto = {
    nome: string;
    cpf: string;
    dispositivo: Maquina;
}

let consertos: Conserto[] = [];

type Input = {
    nome: string;
    cpf: string;
    maquinaTipo: string;
    descricao: string;
    dataConserto: string;
}

export class ConsertoFacade {
    constructor(){
        
    }   

    async RegistrarConserto(data: Input) {
        const dispositivo = DispositivoFactory.create(data.nome, data.cpf, data.maquinaTipo, data.descricao, data.dataConserto);
        const conserto: Conserto = {nome:data.nome,cpf:data.cpf,dispositivo:dispositivo};
        consertos.push(conserto);
        return conserto;
    }

    async ListarConsertos() {
        return consertos;
    }
}