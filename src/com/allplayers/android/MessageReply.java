package com.allplayers.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MessageReply extends Activity
{
	private String threadID;
	private String sendBody;
	
	/** called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.replymessage);
		
		MessageData message = Globals.currentMessage;
		
		String subject = message.getSubject();
		String sender = message.getLastSender();
		String date = message.getDateString();
		threadID = message.getThreadID();
		
		final TextView subjectText = (TextView)findViewById(R.id.subjectText);
		subjectText.setText("This is the Subject.");
		subjectText.setText(subject);
		
		final TextView senderText = (TextView)findViewById(R.id.senderText);
		senderText.setText("This is the Sender's Name.");
		senderText.setText("From: " + sender);
		
		final TextView dateText = (TextView)findViewById(R.id.dateText);
		dateText.setText("This is the Date last sent.");
		dateText.setText("Last Message: " + date);
		
		
		final EditText bodyField = (EditText)findViewById(R.id.bodyField);
		bodyField.setText("This is the Body text.");
		bodyField.setText("");

		final Button sendButton = (Button)findViewById(R.id.sendButton);
		
		sendButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				sendBody = bodyField.getText().toString();

				APCI_RestServices.postMessage(Integer.parseInt(threadID), sendBody);

				Toast toast = Toast.makeText(getBaseContext(), "Message Sent!", Toast.LENGTH_LONG);
				toast.show();

				finish();
			}
		});
	}
}