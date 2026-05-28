import { ApiProperty } from '@nestjs/swagger';

export class ConsertoDTO {
  @ApiProperty({ example: 'Nome do cliente' })
  nome: string;

  @ApiProperty({example: '000.000.000-00'})
  cpf: string;

  @ApiProperty({example: ''})
  maquinaTipo: string;

  @ApiProperty()
  descricao: string;

  @ApiProperty()
  dataConserto: string;
}
