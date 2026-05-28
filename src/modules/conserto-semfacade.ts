import { Controller, Get, Body, Post } from '@nestjs/common';
import { ConsertoDTO } from "./conserto/conserto.dto";
import { Celular } from "./conserto/maquinas/celular"
import { Notebook } from "./conserto/maquinas/notebook"
import { Impressora } from "./conserto/maquinas/impressora"
import { Maquina } from "./conserto/maquinas/maquina"



type Conserto = {
    nome: string;
    cpf: string;
    dispositivo: Maquina;
}


let consertos: Conserto[] = [];

@Controller('conserto-sem-facade')
export class ConsertoSemFacade {
  constructor() {}

  @Post()
  RegistrarConserto(@Body() consertoDTO: ConsertoDTO) {
    let dispositivo: Maquina;
    if(consertoDTO.maquinaTipo === 'celular'){
        dispositivo = new Celular(consertoDTO.descricao);
    }
    else{
        if(consertoDTO.maquinaTipo === 'notebook'){
            dispositivo = new Notebook(consertoDTO.descricao);
        }
        else{
            if(consertoDTO.maquinaTipo === 'impressora'){
                dispositivo = new Impressora(consertoDTO.descricao);
            }
            else{
                throw new Error("Dispositivo inválido");
            }
        }
    }
    const conserto = {nome: consertoDTO.nome, cpf: consertoDTO.cpf, dispositivo: dispositivo};
    consertos.push(conserto);
    return conserto;
  }

  @Get('/listar')
  ListarConsertos() {
    return consertos;
  }
}
