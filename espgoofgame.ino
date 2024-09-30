

const int buttonPin = 0;    
const int del=5; 
int buttonState = 0; 
int timeS = 0;
int num=0;
int uhh;
int getTime();
void lout(int ms);
void sayNo();
void sayYes();

void setup() {
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(buttonPin, INPUT_PULLUP);
  timeS = getTime();
  num=random(1,5);
  uhh=random(1,3);
  digitalWrite(LED_BUILTIN, HIGH);
}

void loop() {
 if(timeS!=0){
 int ans = getTime();
  if((int)((num+uhh)/10)!=(int)num/10){
    
  if(ans>timeS)
  sayYes();
  else sayNo();

 } else {
  if(ans<timeS)
  sayYes();
  else sayNo();
  
 }
 
 }
}

int getTime(){
  int ticks=0;
  while(1){
    buttonState = digitalRead(buttonPin);
    if(buttonState == LOW){
      ticks++;
     // digitalWrite(LED_BUILTIN, HIGH);
    }
    else if(ticks==0){
      digitalWrite(LED_BUILTIN, LOW);
    } else{
      digitalWrite(LED_BUILTIN, LOW);
      break;
    }
   delay(del);
 
  }
  return ticks;
}

void lout(int ms){
  digitalWrite(LED_BUILTIN, HIGH);
  delay(ms*del);
  digitalWrite(LED_BUILTIN, LOW);
}

void sayNo(){
  lout(20);
  delay(del*20);
  lout(20);
}

void sayYes(){
  if(uhh<10)uhh++; else uhh = random(1);
  num+=uhh;
  lout(40);
}
