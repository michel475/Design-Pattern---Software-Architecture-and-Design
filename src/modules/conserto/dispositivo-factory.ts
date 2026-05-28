import { Celular } from "./celular"
import { Notebook } from "./notebook"
import { Impressora } from "./impressora"
import { Maquina } from "./maquina"

export class DispositivoFactory {
    constructor(){}
    static create(nome: string, cpf: string, maquinaTipo: string, descricao: string, dataConserto: string): Maquina {
        switch(maquinaTipo) {
            case "celular":
                return new Celular(descricao);
            case "notebook":
                return new Notebook(descricao);
            case "impressora":
                return new Impressora(descricao);
            default:
                throw new Error("Dispositivo invalido");
        }
    }
}