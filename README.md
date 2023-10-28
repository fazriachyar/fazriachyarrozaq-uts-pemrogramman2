# Program Java untuk UTS Pemrograman 2
Nama : Fazri Achyar Rozaq<br>
NIM : 211011400210<br>
Kelas : 05TPLE001<br>

Repository ini berisi program Java untuk kebutuhan UTS mata kuliah Pemrograman 2. Program ini memiliki alur sebagai berikut:

1. Halaman awal: Pengguna dapat memilih untuk login atau register.
2. Halaman login: Pengguna memasukkan username dan password untuk masuk ke sistem.
3. Halaman utama: Pengguna dapat melihat daftar mahasiswa, mengubah password, atau logout.
4. Halaman daftar mahasiswa: Pengguna dapat melihat daftar mahasiswa yang telah terdaftar di sistem.
5. Halaman ubah password: Pengguna dapat mengubah password akunnya.
6. Halaman logout: Pengguna keluar dari sistem.

## Daftar program

* **Program 1:** Login
* **Program 2:** Register
* **Program 3:** Lihat daftar mahasiswa
* **Program 4:** Ubah password
* **Program 5:** Ubah data mahasiswa
* **Program 6:** Logout

## Petunjuk penggunaan

Untuk menjalankan program, Anda dapat menggunakan NetBeans IDE atau Java Runtime Environment (JRE).

## Lisensi

Program ini didistribusikan dengan lisensi MIT. Anda bebas untuk menggunakan, menyalin, dan mendistribusikan program ini dengan syarat Anda mencantumkan nama penulis dan lisensi.

## Contoh kode

```java
// Program 1: Login

import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class Login {

    public static void main(String[] args) {
        // Buat objek JFrame
        JFrame frame = new JFrame("Login");

        // Buat objek JLabel untuk username
        JLabel labelUsername = new JLabel("Username");

        // Buat objek JTextField untuk username
        JTextField fieldUsername = new JTextField();

        // Buat objek JLabel untuk password
        JLabel labelPassword = new JLabel("Password");

        // Buat objek JPasswordField untuk password
        JPasswordField fieldPassword = new JPasswordField();

        // Buat objek JButton untuk login
        JButton buttonLogin = new JButton("Login");

        // Tambahkan komponen ke frame
        frame.add(labelUsername);
        frame.add(fieldUsername);
        frame.add(labelPassword);
        frame.add(fieldPassword);
        frame.add(buttonLogin);

        // Set layout frame
        frame.setLayout(new FlowLayout());

        // Set ukuran frame
        frame.setSize(300, 200);

        // Tampilkan frame
        frame.setVisible(true);

        // Aksi login
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ambil username dan password dari input user
                String username = fieldUsername.getText();
                String password = new String(fieldPassword.getPassword());

                // Cek apakah username dan password valid
                if (username.equals("admin") && password.equals("admin")) {
                    // Login berhasil
                    JOptionPane.showMessageDialog(frame, "Login berhasil");
                    // Pindah ke halaman utama
                    Main.main(args);
                } else {
                    // Login gagal
                    JOptionPane.showMessageDialog(frame, "Login gagal");
                }
            }
        });
    }
}
