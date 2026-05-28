
import { Controller, Get, Body, Post } from '@nestjs/common';
import { ConsertoFacade } from './conserto.facade';
import { ConsertoDTO } from "./conserto.dto";

@Controller('conserto')
export class ConsertoController {
  constructor(private readonly consertoFacade: ConsertoFacade) {}

  @Post()
  RegistrarConserto(@Body() consertoDTO: ConsertoDTO) {
    return this.consertoFacade.RegistrarConserto(consertoDTO.nome, consertoDTO.cpf, consertoDTO.maquina_tipo, consertoDTO.descricao, consertoDTO.data);
  }

  @Get('/listar')
  ListarConsertos() {
    return this.consertoFacade.ListarConsertos();
  }
}
