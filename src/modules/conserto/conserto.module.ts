import { Module } from '@nestjs/common';
import { ConsertoController } from './conserto.controller';
import { ConsertoService } from './conserto.service'

@Module({
  controllers: [ConsertoController],
  providers: [
    ConsertoService,
  ],
})
export class UsersModule {}
