import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';

import { ConsertoController } from "./modules/conserto/conserto.controller"
import { ConsertoFacade } from "./modules/conserto/conserto.facade"

@Module({
  imports: [],
  controllers: [AppController, ConsertoController],
  providers: [AppService, ConsertoFacade],
})
export class AppModule {}
