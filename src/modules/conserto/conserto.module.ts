import { Module } from '@nestjs/common';
import { ConsertoController } from './conserto.controller';
import { ConsertoFacade } from './conserto.facade'
import { DispositivoFactory } from "./dispositivo-factory"

@Module({
  controllers: [ConsertoController],
  providers: [
    ConsertoFacade,
    {
      provide: 'DispositivoFactory',
      useClass: DispositivoFactory,
    },
  ],
  exports: ['DispositivoFactory']
})
export class UsersModule {}
