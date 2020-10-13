package com.example.spcprofession.ui.addProfession;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.spcprofession.MainActivity;
import com.example.spcprofession.R;

public class AddProfession extends AppCompatActivity {
    private EditText NAME,PROFESSION_NAME,AREA,CONTACAT_NUMBER,EMAIL,SARTING_FEE,DESCRIPTION;
    private Spinner SALARY_RANGE, PROFESSION;
    private String[] professionNames={"Select your Profession","Doctor","Nurse","Data Analyst","Programmer","IT Support","Home Decorator","Networking","Architect Engineer","Lawyer","Legal","Service"};
    private String[] feeRange={"Select a range your fee","0৳ to 1000৳","1000৳ to 2000৳","2000৳ to 3000৳","3000৳ to 4000৳","4000৳ to 5000৳","5000৳ to 6000৳","7000৳ to 8000৳","8000৳ to 10000৳","10000৳ to 20000৳", "20000৳ +"};
    private Button SUBMIT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profession);
        AREA=findViewById(R.id.AREA_NAME);
        PROFESSION=findViewById(R.id.PERSON_PROFESSION);
        NAME=findViewById(R.id.PERSON_NAME);
        DESCRIPTION=findViewById(R.id.DESCRIPTION);
        SUBMIT=findViewById(R.id.SUBMIT_BUTTON);
//
//        ArrayAdapter<String> arrayAdapterFaculty = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, feeRange);
//        arrayAdapterFaculty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        SALARY_RANGE.setAdapter(arrayAdapterFaculty);
        ArrayAdapter<String> arrayAdapterA = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, professionNames);
        arrayAdapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PROFESSION.setAdapter(arrayAdapterA);
        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(NAME.getText().length()<2 || DESCRIPTION.getText().length()<10||AREA.getText().length()<2)
                {
                    Toast.makeText(AddProfession.this,"Please insert proper value",Toast.LENGTH_LONG).show();
                }
                SaveData saveData=new SaveData();
                saveData.savePost(AddProfession.this,NAME.getText().toString(),PROFESSION.getSelectedItem().toString(),DESCRIPTION.getText().toString(),AREA.getText().toString());

            }
        });



    }
}