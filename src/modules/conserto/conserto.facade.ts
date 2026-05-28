import { DispositivoFactory } from "./dispositivo-factory"
import { Maquina } from "./maquina"

type Conserto = {
    nome: string;
    cpf: string;
    dispositivo: Maquina;
}

let consertos: Conserto[] = [];

export class ConsertoFacade {
    constructor(){
        
    }   

    async RegistrarConserto(nome: string, cpf: string, maquinaTipo: string, descricao: string, dataConserto: string) {
        const dispFac = DispositivoFactory.create(nome, cpf, maquinaTipo, descricao, dataConserto);
        const conserto: Conserto = {nome:nome,cpf:cpf,dispositivo:dispFac};
        consertos.push(conserto);
        return conserto;
    }

    async ListarConsertos() {
        return consertos;
    }
}