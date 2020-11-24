package com.example.a402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowPointActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_point);;

        ((TextView) findViewById(R.id.test_level_at)).setText("แบบฝึกหัดชุดที่ "+(Main2Activity.currentLevel+1));
        ((TextView) findViewById(R.id.word_at)).setText("คำที่ "+(Main2Activity.currentWord+1));

        if(Main2Activity.currentLevel == 0){
            String giveWord = getResources()
                    .getStringArray(R.array.level_1)[Main2Activity.currentWord];

            setRightWord(giveWord);
            String resultWord = getIntent().getStringExtra("resultWord");
            ((TextView) findViewById(R.id.score)).setText(calScore(resultWord, giveWord)+" คะแนน");
        }
        else if(Main2Activity.currentLevel == 1){
            String giveWord = getResources()
                    .getStringArray(R.array.level_2)[Main2Activity.currentWord];

            setRightWord(giveWord);
            String resultWord = getIntent().getStringExtra("resultWord");
            ((TextView) findViewById(R.id.score)).setText(calScore(resultWord, giveWord)+" คะแนน");
        }
        else if(Main2Activity.currentLevel == 2){
            String giveWord = getResources()
                    .getStringArray(R.array.level_3)[Main2Activity.currentWord];

            setRightWord(giveWord);
            String resultWord = getIntent().getStringExtra("resultWord");
            ((TextView) findViewById(R.id.score)).setText(calScore(resultWord, giveWord)+" คะแนน");
        }

    }

    public void nextWord(View view){
        Main2Activity.currentWord +=1;
        Intent intent = null;
        if(Main2Activity.currentWord == 10){
            intent = new Intent( ShowPointActivity.this, ShowAllActivity.class);
        }
        else{
            intent = new Intent( ShowPointActivity.this, ShowWordActivity.class);
        }
        startActivity(intent);
        finish();
    }

    public void setRightWord(String giveWord){
        if(giveWord.equals("พยาธิวิทยา")){
            ((TextView) findViewById(R.id.right_word)).setText("พะ-ยา-ทิ-วิด-ทะ-ยา");
        }
        else if(giveWord.equals("กรกฎาคม")){
            ((TextView) findViewById(R.id.right_word)).setText("กะ-ระ-กะ-ดา-คม");
        }
        else if(giveWord.equals("พระบรมธาตุ")){
            ((TextView) findViewById(R.id.right_word)).setText("พระ-บอ-รม-มะ-ทาด");
        }
        else if(giveWord.equals("พิจารณา")){
            ((TextView) findViewById(R.id.right_word)).setText("พิ-จา-ระ-นา");
        }
        else if(giveWord.equals("เพลา")){
            ((TextView) findViewById(R.id.right_word)).setText("เพ-ลา");
        }
        else if(giveWord.equals("เพรา")){
            ((TextView) findViewById(R.id.right_word)).setText("เพรา");
        }
        else if(giveWord.equals("แถลง")){
            ((TextView) findViewById(R.id.right_word)).setText("ถะ-แหลง");
        }
        else if(giveWord.equals("กามตัณหา")){
            ((TextView) findViewById(R.id.right_word)).setText("กาม-มะ-ตัน-หา");
        }
        else if(giveWord.equals("ขัดสมาธิ")){
            ((TextView) findViewById(R.id.right_word)).setText("ขัด-สะ-หมาด");
        }
        else if(giveWord.equals("ปฐมวัย")){
            ((TextView) findViewById(R.id.right_word)).setText("ปะ-ถม-มะ-ไว");
        }
        else if(giveWord.equals("วิตถาร")){
            ((TextView) findViewById(R.id.right_word)).setText("วิด-ถาน");
        }
        else if(giveWord.equals("สวรรคต")){
            ((TextView) findViewById(R.id.right_word)).setText("สะ-หวัน-คด");
        }
        else if(giveWord.equals("สัตบุรุษ")){
            ((TextView) findViewById(R.id.right_word)).setText("สัด-บุ-หรุด");
        }
        else if(giveWord.equals("อัสนีบาต")){
            ((TextView) findViewById(R.id.right_word)).setText("อะ-สะ-นี-บาด");
        }
        else if(giveWord.equals("อุณหภูมิ")){
            ((TextView) findViewById(R.id.right_word)).setText("อุน-หะ-พูม");
        }
        else if(giveWord.equals("คุณโทษ")){
            ((TextView) findViewById(R.id.right_word)).setText("คุน-โทด");
        }
        else if(giveWord.equals("คุณลักษณะ")){
            ((TextView) findViewById(R.id.right_word)).setText("คุน-นะ-ลัก-สะ-หนะ");
        }
        else if(giveWord.equals("เฉลิมพระชนมพรรษา")){
            ((TextView) findViewById(R.id.right_word)).setText("ฉะ-เหลิม-พระ-ชน-มะ-พัน-ษา");
        }
        else if(giveWord.equals("ปราชัย")){
            ((TextView) findViewById(R.id.right_word)).setText("ปะ-รา-ชัย");
        }
        else if(giveWord.equals("ซอมซ่อ")){
            ((TextView) findViewById(R.id.right_word)).setText("ซอม-มะ-ซ่อ");
        }
        else if(giveWord.equals("ตุ๊กตา")){
            ((TextView) findViewById(R.id.right_word)).setText("ตุ๊ก-กะ-ตา");
        }
        else if(giveWord.equals("โฆษณา")){
            ((TextView) findViewById(R.id.right_word)).setText("โคด-สะ-นา");
        }
        else if(giveWord.equals("ว่าวปักเป้า")){
            ((TextView) findViewById(R.id.right_word)).setText("ว่าว-ปัก-เป้า");
        }
        else if(giveWord.equals("ปลาปักเป้า")){
            ((TextView) findViewById(R.id.right_word)).setText("ปลา-ปัก-กะ-เป้า");
        }
        else if(giveWord.equals("กามราคะ")){
            ((TextView) findViewById(R.id.right_word)).setText("กาม-มะ-รา-คะ");
        }
        else if(giveWord.equals("จระเข้")){
            ((TextView) findViewById(R.id.right_word)).setText("จอ-ระ-เข้");
        }
        else if(giveWord.equals("กรมธรรม์")){
            ((TextView) findViewById(R.id.right_word)).setText("กรม-มะ-ทัน");
        }
        else if(giveWord.equals("ทิฐิ")){
            ((TextView) findViewById(R.id.right_word)).setText("ทิด-ถิ");
        }
        else if(giveWord.equals("อหิวาตกโรค")){
            ((TextView) findViewById(R.id.right_word)).setText("อะ-หิ-วา-ตะ-กะ-โรค");
        }
        else if(giveWord.equals("ชนมพรรษา")){
            ((TextView) findViewById(R.id.right_word)).setText("ชน-มะ-พัน-สา");
        }
    }

    public double calScore(String resultWord, String giveWord){
        double SumPoint = 0;//ตัวเก็บคะแนน
        if(resultWord.equals("พยาธิวิทยา") && giveWord.equals("พยาธิวิทยา")){
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("พะ-ยา-ทิ-วิด-ทะ-ยา");
        }
        else if(resultWord.equals("พะยาดวิดทะยา") && giveWord.equals("พยาธิวิทยา")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("พะ-ยาด-วิด-ทะ-ยา");
        }
        else if(resultWord.equals("พะยาดวิดยา") && giveWord.equals("พยาธิวิทยา")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("พะ-ยาด-วิด-ยา");
        }
        else if(resultWord.equals("พะยาทิวิดยา") && giveWord.equals("พยาธิวิทยา")) {
            SumPoint +=8.33;
            ((TextView) findViewById(R.id.read_word)).setText("พะ-ยา-ทิ-วิด-ยา");
        }
        else if(resultWord.equals("กรกฎาคม") && giveWord.equals("กรกฎาคม")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("กะ-ระ-กะ-ดา-คม");
        }
        else if(resultWord.equals("กะดั๊กกะดาคม") && giveWord.equals("กรกฎาคม")) {
            SumPoint +=8;
            ((TextView) findViewById(R.id.read_word)).setText("กะ-ดั๊ก-กะ-ดา-คม");
        }
        else if(resultWord.equals("กอระกะดาคม") && giveWord.equals("กรกฎาคม")) {
            SumPoint +=8;
            ((TextView) findViewById(R.id.read_word)).setText("กอ-ระ-กะ-ดา-คม");
        }
        else if(resultWord.equals("กะระกอดาคม") && giveWord.equals("กรกฎาคม")) {
            SumPoint +=8;
            ((TextView) findViewById(R.id.read_word)).setText("กะ-ระ-กอ-ดา-คม");
        }
        else if(resultWord.equals("กอระกอดาคม") && giveWord.equals("กรกฎาคม")) {
            SumPoint +=6;
            ((TextView) findViewById(R.id.read_word)).setText("กอ-ระ-กอ-ดา-คม");
        }
        else if(resultWord.equals("พระบรมธาตุ") && giveWord.equals("พระบรมธาตุ")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("พระ-บอ-รม-มะ-ทาด");
        }
        else if(resultWord.equals("พระบอรมมาทาด") && giveWord.equals("พระบรมธาตุ")) {
            SumPoint +=8;
            ((TextView) findViewById(R.id.read_word)).setText("พระ-บอ-รม-มา-ทาด");
        }
        else if(resultWord.equals("พระบะรมมะทาด") && giveWord.equals("พระบรมธาตุ")) {
            SumPoint +=8;
            ((TextView) findViewById(R.id.read_word)).setText("พระ-บะ-รม-มะ-ทาด");
        }
        else if(resultWord.equals("พระบะรมมาทาด") && giveWord.equals("พระบรมธาตุ")) {
            SumPoint +=6;
            ((TextView) findViewById(R.id.read_word)).setText("พะ-บะ-รม-มา-ทาด");
        }
        else if(resultWord.equals("พิจารณา") && giveWord.equals("พิจารณา")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("พิ-จา-ระ-นา");
        }
        else if(resultWord.equals("พิดจาระนา") && giveWord.equals("พิจารณา")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("พิด-จา-ระ-นา");
        }
        else if(resultWord.equals("พิดนา") && giveWord.equals("พิจารณา")) {
            SumPoint +=2.5;
            ((TextView) findViewById(R.id.read_word)).setText("พิด-นา");
        }
        else if(resultWord.equals("พิดจานา") && giveWord.equals("พิจารณา")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("พิด-จา-นา");
        }
        else if(resultWord.equals("เพลา") && giveWord.equals("เพลา")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("เพ-ลา");
        }
        else if(resultWord.equals("เพลาร์") && giveWord.equals("เพลา")) {
            SumPoint +=0;
            ((TextView) findViewById(R.id.read_word)).setText("เพา");
        }
        else if(resultWord.equals("เพรา") && giveWord.equals("เพรา")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("เพรา");
        }
        else if(resultWord.equals("เพราร์") && giveWord.equals("เพรา")) {
            SumPoint +=0;
            ((TextView) findViewById(R.id.read_word)).setText("เพ-รา");
        }
        else if(resultWord.equals("พะเลา") && giveWord.equals("เพรา")) {
            SumPoint +=0;
            ((TextView) findViewById(R.id.read_word)).setText("พะ-เลา");
        }
        else if(resultWord.equals("แถลง") && giveWord.equals("แถลง")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("ถะ-แหลง");
        }
        else if(resultWord.equals("แถลงร์") && giveWord.equals("แถลง")) {
            SumPoint +=0;
            ((TextView) findViewById(R.id.read_word)).setText("แถง");
        }
        else if(resultWord.equals("ถะแลง") && giveWord.equals("แถลง")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("ถะ-แลง");
        }
        else if(resultWord.equals("กามตัณหา") && giveWord.equals("กามตัณหา")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("กาม-มะ-ตัน-หา");
        }
        else if(resultWord.equals("กามตันหาร์") && giveWord.equals("กามตัณหา")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("กาม-ตัน-หา");
        }
        else if(resultWord.equals("กามะตันหา") && giveWord.equals("กามตัณหา")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("กา-มะ-ตัน-หา");
        }
        else if(resultWord.equals("กะมะตันหา") && giveWord.equals("กามตัณหา")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("กะ-มะ-ตัน-หา");
        }
        else if(resultWord.equals("ขัดสมาธิ") && giveWord.equals("ขัดสมาธิ")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("ขัด-สะ-หมาด");
        }
        else if(resultWord.equals("ขัดสะมาทิ") && giveWord.equals("ขัดสมาธิ")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("ขัด-สะ-มา-ทิ");
        }
        else if(resultWord.equals("ขะสะมาทิ") && giveWord.equals("ขัดสมาธิ")) {
            SumPoint +=0;
            ((TextView) findViewById(R.id.read_word)).setText("ขะ-สะ-มา-ทิ");
        }
        else if(resultWord.equals("ขัดหมาด") && giveWord.equals("ขัดสมาธิ")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("ขัด-หมาด");
        }
        else if(resultWord.equals("ขัดมาทิ") && giveWord.equals("ขัดสมาธิ")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("ขัด-มา-ทิ");
        }
        else if(resultWord.equals("ปฐมวัย") && giveWord.equals("ปฐมวัย")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("ปะ-ถม-มะ-ไว");
        }
        else if(resultWord.equals("ปะถมไว") && giveWord.equals("ปฐมวัย")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("ปะ-ถม-ไว");
        }
        else if(resultWord.equals("ปะทะมะไว") && giveWord.equals("ปฐมวัย")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("ปะ-ทะ-มะ-ไว");
        }
        else if(resultWord.equals("ถมไว") && giveWord.equals("ปฐมวัย")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("ถม-ไว");
        }
        else if(resultWord.equals("ถมมะไว") && giveWord.equals("ปฐมวัย")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("ถม-มะ-ไว");
        }
        else if(resultWord.equals("วิตถาร") && giveWord.equals("วิตถาร")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("วิด-ถาน");
        }
        else if(resultWord.equals("วิดตะถาร") && giveWord.equals("วิตถาร")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("วิด-ตะ-ถาน");
        }
        else if(resultWord.equals("วะตะถาน") && giveWord.equals("วิตถาร")) {
            SumPoint +=0;
            ((TextView) findViewById(R.id.read_word)).setText("วะ-ตะ-ถาน");
        }
        else if(resultWord.equals("วิตาถาน") && giveWord.equals("วิตถาร")) {
            SumPoint +=0;
            ((TextView) findViewById(R.id.read_word)).setText("วิ-ตา-ถาน");
        }
        else if(resultWord.equals("วิตะถาน") && giveWord.equals("วิตถาร")) {
            SumPoint +=0;
            ((TextView) findViewById(R.id.read_word)).setText("วิ-ตะ-ถาน");
        }
        else if(resultWord.equals("สวรรคต") && giveWord.equals("สวรรคต")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("สะ-หวัน-คด");
        }
        else if(resultWord.equals("สะหวันนะคด") && giveWord.equals("สวรรคต")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("สะ-หวัน-นะ-คด");
        }
        else if(resultWord.equals("สะวะนะคด") && giveWord.equals("สวรรคต")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("สะ-วะ-นะ-คด");
        }
        else if(resultWord.equals("โสะวันคด") && giveWord.equals("สวรรคต")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("โสะ-หวัน-คด");
        }
        else if(resultWord.equals("หวันคด") && giveWord.equals("สวรรคต")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("หวัน-คด");
        }
        else if(resultWord.equals("สัตบุรุษ") && giveWord.equals("สัตบุรุษ")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("สัด-บุ-หรุด");
        }
        else if(resultWord.equals("สัดตะบุหรุด") && giveWord.equals("สัตบุรุษ")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("สัด-ตะ-บุ-หลุด");
        }
        else if(resultWord.equals("สะตะบุหลุด") && giveWord.equals("สัตบุรุษ")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("สะ-ตะ-บุ-หลุด");
        }
        else if(resultWord.equals("สะตัดบุหรุด") && giveWord.equals("สัตบุรุษ")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("สะ-ตัด-บุ-หลุด");
        }
        else if(resultWord.equals("อัสนีบาต") && giveWord.equals("อัสนีบาต")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("อะ-สะ-นี-บาด");
        }
        else if(resultWord.equals("อัดสะนีบาด") && giveWord.equals("อัสนีบาต")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("อัด-สะ-นี-บาด");
        }
        else if(resultWord.equals("อัดนีบาด") && giveWord.equals("อัสนีบาต")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("อัด-นี-บาด");
        }
        else if(resultWord.equals("สะนีบาด") && giveWord.equals("อัสนีบาต")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("สะ-นี-บาด");
        }
        else if(resultWord.equals("อดสะนีบาด") && giveWord.equals("อัสนีบาต")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("อด-สะ-นี-บาด");
        }
        else if(resultWord.equals("อดนีบาด") && giveWord.equals("อัสนีบาต")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("อด-นี-บาด");
        }
        else if(resultWord.equals("อุณหภูมิ") && giveWord.equals("อุณหภูมิ")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("อุน-หะ-พูม");
        }
        else if(resultWord.equals("อุนนะหะพูม") && giveWord.equals("อุณหภูมิ")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("อุน-นะ-หะ-พูม");
        }
        else if(resultWord.equals("อุนนะพูม") && giveWord.equals("อุณหภูมิ")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("อุน-นะ-พูม");
        }
        else if(resultWord.equals("อุนพูม") && giveWord.equals("อุณหภูมิ")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("อุน-พูม");
        }
        else if(resultWord.equals("อะนะภูม") && giveWord.equals("อุณหภูมิ")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("อะ-นะ-พูม");
        }
        else if(resultWord.equals("อนนะภูม") && giveWord.equals("อุณหภูมิ")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("อน-นะ-พูม");
        }
        else if(resultWord.equals("อนนะหะพูม") && giveWord.equals("อุณหภูมิ")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("อน-นะ-หะ-พูม");
        }
        else if(resultWord.equals("คุณโทษ") && giveWord.equals("คุณโทษ")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("คุน-โทด");
        }
        else if(resultWord.equals("คุณนะโทด") && giveWord.equals("คุณโทษ")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("คุน-นะ-โทด");
        }
        else if(resultWord.equals("คนโทด") && giveWord.equals("คุณโทษ")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("คน-โทด");
        }
        else if(resultWord.equals("คนนะโทด") && giveWord.equals("คุณโทษ")) {
            SumPoint +=0;
            ((TextView) findViewById(R.id.read_word)).setText("คน-นะ-โทด");
        }
        else if(resultWord.equals("คุณลักษณะ") && giveWord.equals("คุณลักษณะ")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("คุน-นะ-ลัก-สะ-หนะ");
        }
        else if(resultWord.equals("คุนลักสะหนะ") && giveWord.equals("คุณลักษณะ")) {
            SumPoint +=8;
            ((TextView) findViewById(R.id.read_word)).setText("คุน-ลัก-สะ-หนะ");
        }
        else if(resultWord.equals("คุนนะลักหนะ") && giveWord.equals("คุณลักษณะ")) {
            SumPoint +=8;
            ((TextView) findViewById(R.id.read_word)).setText("คุน-นะ-ลัก-หนะ");
        }
        else if(resultWord.equals("คุนนะละหนะ") && giveWord.equals("คุณลักษณะ")) {
            SumPoint +=6;
            ((TextView) findViewById(R.id.read_word)).setText("คุน-นะ-ละ-หนะ");
        }
        else if(resultWord.equals("คุนนะละสะหนะ") && giveWord.equals("คุณลักษณะ")) {
            SumPoint +=8;
            ((TextView) findViewById(R.id.read_word)).setText("คุน-นะ-ละ-สะ-หนะ");
        }
        else if(resultWord.equals("เฉลิมพระชนมพรรษา") && giveWord.equals("เฉลิมพระชนมพรรษา")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("ฉะ-เหลิม-พระ-ชน-มะ-พัน-สา");
        }
        else if(resultWord.equals("ฉะเหลิมพระชนพันสา") && giveWord.equals("เฉลิมพระชนมพรรษา")) {
            SumPoint +=8.57;
            ((TextView) findViewById(R.id.read_word)).setText("ฉะ-เหลิม-พระ-ชน-พัน-สา");
        }
        else if(resultWord.equals("เฉิมชนพันสา") && giveWord.equals("เฉลิมพระชนมพรรษา")) {
            SumPoint +=4.28;
            ((TextView) findViewById(R.id.read_word)).setText("เฉิม-ชน-พัน-สา");
        }
        else if(resultWord.equals("เฉิมชนมะพันสา") && giveWord.equals("เฉลิมพระชนมพรรษา")) {
            SumPoint +=5.71;
            ((TextView) findViewById(R.id.read_word)).setText("เฉิม-ชน-มะ-พัน-สา");
        }
        else if(resultWord.equals("ฉะเหลิมชนพันสา") && giveWord.equals("เฉลิมพระชนมพรรษา")) {
            SumPoint +=7.14;
            ((TextView) findViewById(R.id.read_word)).setText("ฉะ-เหลิม-ชน-พัน-สา");
        }
        else if(resultWord.equals("เฉิมพระชนพันสา") && giveWord.equals("เฉลิมพระชนมพรรษา")) {
            SumPoint +=5.71;
            ((TextView) findViewById(R.id.read_word)).setText("เฉิม-พระ-ชน-พัน-ษา");
        }
        else if(resultWord.equals("ปราชัย") && giveWord.equals("ปราชัย")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("ปะ-รา-ชัย");
        }
        else if(resultWord.equals("ปราไช") && giveWord.equals("ปราชัย")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("ปรา-ชัย");
        }
        else if(resultWord.equals("ปะระไช") && giveWord.equals("ปราชัย")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("ปะ-ระ-ชัย");
        }
        else if(resultWord.equals("ซอมซ่อ") && giveWord.equals("ซอมซ่อ")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("ซอม-มะ-ซ่อ");
        }
        else if(resultWord.equals("ซอมซ่อร์") && giveWord.equals("ซอมซ่อ")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("ซอม-ซ่อ");
        }
        else if(resultWord.equals("ซะอะมะซ่อ") && giveWord.equals("ซอมซ่อ")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("ซะ-อะ-มะ-ซ่อ");
        }
        else if(resultWord.equals("ซมซ่อ") && giveWord.equals("ซอมซ่อ")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("ซม-ซ่อ");
        }
        else if(resultWord.equals("ตุ๊กตา") && giveWord.equals("ตุ๊กตา")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("ตุ๊ก-กะ-ตา");
        }
        else if(resultWord.equals("ตุ๊กตาร์") && giveWord.equals("ตุ๊กตา")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("ตุ๊ก-ตา");
        }
        else if(resultWord.equals("ตกกะตา") && giveWord.equals("ตุ๊กตา")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("ตก-กะ-ตา");
        }
        else if(resultWord.equals("ตุกตา") && giveWord.equals("ตุ๊กตา")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("ตุก-ตา");
        }
        else if(resultWord.equals("ตะกะตา") && giveWord.equals("ตุ๊กตา")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("ตะ-กะ-ตา");
        }
        else if(resultWord.equals("โฆษณา") && giveWord.equals("โฆษณา")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("โคด-สะ-นา");
        }
        else if(resultWord.equals("โค้สะนา") && giveWord.equals("โฆษณา")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("โค้-สะ-นา");
        }
        else if(resultWord.equals("โคสะนา") && giveWord.equals("โฆษณา")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("โค-สะ-นา");
        }
        else if(resultWord.equals("โคดนา") && giveWord.equals("โฆษณา")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("โคด-นา");
        }
        else if(resultWord.equals("โค้นา") && giveWord.equals("โฆษณา")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("โค้-นา");
        }
        else if(resultWord.equals("โคนะ") && giveWord.equals("โฆษณา")) {
            SumPoint +=0;
            ((TextView) findViewById(R.id.read_word)).setText("โค-นะ");
        }
        else if(resultWord.equals("ว่าวปักเป้า") && giveWord.equals("ว่าวปักเป้า")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("ว่าว-ปัก-เป้า");
        }
        else if(resultWord.equals("ว่าวปักกะเป้า") && giveWord.equals("ว่าวปักเป้า")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("ว่าว-ปัก-กะ-เป้า");
        }
        else if(resultWord.equals("ปลาปักเป้า") && giveWord.equals("ปลาปักเป้า")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("ปลา-ปัก-กะ-เป้า");
        }
        else if(resultWord.equals("ปลาปักเป้าร์") && giveWord.equals("ปลาปักเป้า")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("ปลา-ปัก-เป้า");
        }
        else if(resultWord.equals("กามราคะ") && giveWord.equals("กามราคะ")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("กาม-มะ-รา-คะ");
        }
        else if(resultWord.equals("กามราคะร์") && giveWord.equals("กามราคะ")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("กาม-รา-คะ");
        }
        else if(resultWord.equals("กามะราคะ") && giveWord.equals("กามราคะ")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("กา-มะ-รา-คะ");
        }
        else if(resultWord.equals("การาคะ") && giveWord.equals("กามราคะ")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("กา-รา-คะ");
        }
        else if(resultWord.equals("จรเข้") && giveWord.equals("จระเข้")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("จอ-ระ-เข้");
        }
        else if(resultWord.equals("จะระเข้") && giveWord.equals("จระเข้")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("จะ-ระ-เข้");
        }
        else if(resultWord.equals("จะเข้") && giveWord.equals("จระเข้")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("จะ-เข้");
        }
        else if(resultWord.equals("จอเข้") && giveWord.equals("จระเข้")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("จอ-เข้");
        }
        else if(resultWord.equals("ตะเข้") && giveWord.equals("จระเข้")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("ตะ-เข้");
        }
        else if(resultWord.equals("กรมธรรม์") && giveWord.equals("กรมธรรม์")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("กรม-มะ-ทัน");
        }
        else if(resultWord.equals("กรมทำ") && giveWord.equals("กรมธรรม์")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("กรม-ทำ");
        }
        else if(resultWord.equals("กรมทัน") && giveWord.equals("กรมธรรม์")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("กรม-ทัน");
        }
        else if(resultWord.equals("กะมะทัน") && giveWord.equals("กรมธรรม์")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("กะ-มะ-ทัน");
        }
        else if(resultWord.equals("กะมะทำ") && giveWord.equals("กรมธรรม์")) {
            SumPoint +=3.33;
            ((TextView) findViewById(R.id.read_word)).setText("กะ-มะ-ทำ");
        }
        else if(resultWord.equals("ทิฐิ") && giveWord.equals("ทิฐิ")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("ทิด-ถิ");
        }
        else if(resultWord.equals("ทิถิ") && giveWord.equals("ทิฐิ")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("ทิ-ถิ");
        }
        else if(resultWord.equals("ทัดถิ") && giveWord.equals("ทิฐิ")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("ทัด-ถิ");
        }
        else if(resultWord.equals("ทะถิ") && giveWord.equals("ทิฐิ")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("ทะ-ถิ");
        }
        else if(resultWord.equals("อหิวาตกโรค") && giveWord.equals("อหิวาตกโรค")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("อะ-หิ-วา-ตะ-กะ-โรค");
        }
        else if(resultWord.equals("อะหิวาตกกะโรก") && giveWord.equals("อหิวาตกโรค")) {
            SumPoint +=8.33;
            ((TextView) findViewById(R.id.read_word)).setText("อะ-หิ-วา-ตก-กะ-โรค");
        }
        else if(resultWord.equals("อะหิวาตกโรค") && giveWord.equals("อหิวาตกโรค")) {
            SumPoint +=6.67;
            ((TextView) findViewById(R.id.read_word)).setText("อะ-หิ-วา-ตก-โรค");
        }
        else if(resultWord.equals("อะฮิววาตกโรค") && giveWord.equals("อหิวาตกโรค")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("อะ-ฮิว-วา-ตก-โรค");
        }
        else if(resultWord.equals("ชนมพรรษา") && giveWord.equals("ชนมพรรษา")) {
            SumPoint +=10;
            ((TextView) findViewById(R.id.read_word)).setText("ชน-มะ-พัน-สา");
        }
        else if(resultWord.equals("ชมพันษา") && giveWord.equals("ชนมพรรษา")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("ชม-พัน-สา");
        }
        else if(resultWord.equals("ชะนะมะพันสา") && giveWord.equals("ชนมพรรษา")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("ชะ-นะ-มะ-พัน-สา");
        }
        else if(resultWord.equals("ชมมะพันสา") && giveWord.equals("ชนมพรรษา")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("ชม-มะ-พัน-สา");
        }
        else if(resultWord.equals("ชนนะพันสา") && giveWord.equals("ชนมพรรษา")) {
            SumPoint +=7.5;
            ((TextView) findViewById(R.id.read_word)).setText("ชน-นะ-พัน-สา");
        }
        else if(resultWord.equals("วิดถะถาน") && giveWord.equals("วิตถาร")) {
            SumPoint +=5;
            ((TextView) findViewById(R.id.read_word)).setText("วิด-ถะ-ถาน");
        }
        else if(resultWord.equals("วิถะถาน") && giveWord.equals("วิตถาร")) {
            SumPoint +=0;
            ((TextView) findViewById(R.id.read_word)).setText("วิ-ถะ-ถาน");
        }
        else{
            ((TextView) findViewById(R.id.read_word)).setText("ไม่มีคำที่ใกล้เคียง");
        }
        Main2Activity.totalScore += SumPoint;
        return SumPoint;
    }
}
