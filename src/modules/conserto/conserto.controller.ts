
import { Controller, Get, Body, Post } from '@nestjs/common';
import { ConsertoService } from './conserto.service';
import { ConsertoDTO } from "./conserto.dto";

@Controller('conserto')
export class ConsertoController {
  constructor(private readonly consertoService: ConsertoService) {}

  @Post()
  RegistrarConserto(@Body('') consertoDTO: ConsertoDTO) {
    return this.consertoService.RegistrarConserto(consertoDTO.nome, consertoDTO.cpf, consertoDTO.maquina_tipo, consertoDTO.descricao, consertoDTO.data);
  }
}
