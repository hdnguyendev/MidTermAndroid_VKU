package hdn.dev.midtermandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    private AppCompatButton btnSave, btnCancel;
    private EditText tfName, tfPhone, tfEmail;

    ContactRepository res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        res = new ContactRepository(getApplication());
        // init
        this.btnSave = findViewById(R.id.btnSave);
        this.btnCancel = findViewById(R.id.btnCancel);
        this.tfName = findViewById(R.id.tfName);
        this.tfPhone = findViewById(R.id.tfPhone);
        this.tfEmail = findViewById(R.id.tfEmail);


        // controller
        tfName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence,
                                          int i, int i1, int i2) {

                //Gọi trước khi text thay đổi
            }

            @Override
            public void onTextChanged(CharSequence charSequence,
                                      int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    tfName.setError("Bạn bắt buộc phải nhập số điện thoại");
                } else {
                    tfName.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        });
        tfPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence,
                                          int i, int i1, int i2) {

                //Gọi trước khi text thay đổi
            }

            @Override
            public void onTextChanged(CharSequence charSequence,
                                      int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    tfPhone.setError("Bạn bắt buộc phải nhập số điện thoại");
                } else {
                    tfPhone.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String phoneNumber = s.toString();

                // Kiểm tra xem số điện thoại có hợp lệ hay không
                if (!isValidPhoneNumber(phoneNumber)) {
                    tfPhone.setError("Số điện thoại không hợp lệ");
                } else {
                    tfPhone.setError(null);
                }

            }


        });
        tfEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence,
                                          int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    tfEmail.setError("Bạn bắt buộc phải nhập Email");
                } else {
                    tfEmail.setError(null);
                }
                //Gọi trước khi text thay đổi
            }

            @Override
            public void onTextChanged(CharSequence charSequence,
                                      int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    tfEmail.setError("Bạn bắt buộc phải nhập Email");
                } else {
                    tfEmail.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String email = s.toString();

                // Kiểm tra xem email có hợp lệ hay không
                if (!isValidEmail(email)) {
                    tfEmail.setError("Email không hợp lệ");
                } else {
                    tfEmail.setError(null);
                }
            }


        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tfPhone.getError() != null || tfEmail.getError() != null) {
                    Toast.makeText(AddActivity.this, "Vui lòng sửa lỗi trước khi lưu", Toast.LENGTH_SHORT).show();
                } else {
                    finish();
                    Contact contact = new Contact();
                    String name = tfName.getText().toString();
                    contact.setName(name);
                    String phone = tfPhone.getText().toString();
                    contact.setPhone(phone);
                    String email = tfEmail.getText().toString();
                    contact.setEmail(email);
                    res.insert(contact);
                    Intent intent1 = new Intent(AddActivity.this, MainActivity.class);
                    startActivity(intent1);
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent1 = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }

    // function validate
    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        return Patterns.PHONE.matcher(phoneNumber).matches();
    }

    private boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}