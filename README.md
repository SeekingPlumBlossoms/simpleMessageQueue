# 工程说明
 简易消息中心的实现
 
 ## BrokerServer
   表示消息的分发中心 启动main方法监听9999
 
 ##ProduceClient
   表示生产者
   启动main方法 
   BrokerServer服务出现：
    接受到的原始数据为：hello world
    成功向消息中心投递消息：hello world,当前暂存的消息的数量是：1
    ======================================================
   表示消息投递成功
 ##ConsumeClient
    表示消费者
    启动main方法 
    BrokerServer服务出现：
    接受到的原始数据为：CONSUME
    已经消费消息：hello world,当前暂存的消息数量为：2
    =================================================
  
    ConsumeClient服务出现：
    获取到的消息为：hello world
  
   表示消息消费成功  
   
## MqClient
  封装了对9999端口消息的发送以及接受;目前的模式只有拉取的模式，没有推送的模式